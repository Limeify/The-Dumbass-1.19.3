package net.limeify.thedumbass.entity.client.renderer;

import net.limeify.thedumbass.TheDumbass;
import net.limeify.thedumbass.entity.client.ThursdayMorningPiglinModel;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class ThursdayMorningPiglinRenderer extends GeoEntityRenderer<ThursdayMorningPiglin>
{
    private static final String LEFT_HAND = "HandLeft";
    private static final String RIGHT_HAND = "HandRight";
    private static final String LEFT_BOOT = "armorLeftFoot";
    private static final String RIGHT_BOOT = "armorRightFoot";
    private static final String LEFT_ARMOR_LEG = "armorLeftLeg";
    private static final String RIGHT_ARMOR_LEG = "armorRightLeg";
    private static final String CHESTPLATE = "armorBody";
    private static final String RIGHT_SLEEVE = "armorRightArm";
    private static final String LEFT_SLEEVE = "armorLeftArm";
    private static final String HELMET = "armorBipedHead";
    protected ItemStack mainHandItem;
    protected ItemStack offhandItem;

    public ThursdayMorningPiglinRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ThursdayMorningPiglinModel());
        this.shadowRadius = 0.5f;

        this.addRenderLayer(new ItemArmorGeoLayer<>(this) {
            @Nullable
            protected ItemStack getArmorItemForBone(GeoBone bone, ThursdayMorningPiglin animatable) {

                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> this.bootsStack;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> this.leggingsStack;
                    case CHESTPLATE, RIGHT_SLEEVE, LEFT_SLEEVE -> this.chestplateStack;
                    case HELMET -> this.helmetStack;
                    default -> null;
                };
            }

            protected @NotNull EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, ThursdayMorningPiglin animatable) {

                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> EquipmentSlot.FEET;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> EquipmentSlot.LEGS;
                    case RIGHT_SLEEVE -> !animatable.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                    case LEFT_SLEEVE -> animatable.isLeftHanded() ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                    case CHESTPLATE -> EquipmentSlot.CHEST;
                    case HELMET -> EquipmentSlot.HEAD;
                    default -> super.getEquipmentSlotForBone(bone, stack, animatable);
                };
            }

            protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, ThursdayMorningPiglin animatable, BipedEntityModel<?> baseModel) {

                return switch (bone.getName()) {
                    case LEFT_BOOT, LEFT_ARMOR_LEG -> baseModel.leftLeg;
                    case RIGHT_BOOT, RIGHT_ARMOR_LEG -> baseModel.rightLeg;
                    case RIGHT_SLEEVE -> baseModel.rightArm;
                    case LEFT_SLEEVE -> baseModel.leftArm;
                    case CHESTPLATE -> baseModel.body;
                    case HELMET -> baseModel.head;
                    default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
                };
            }
        });
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getStackForBone(GeoBone bone, ThursdayMorningPiglin animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> animatable.isLeftHanded() ?
                            ThursdayMorningPiglinRenderer.this.mainHandItem : ThursdayMorningPiglinRenderer.this.offhandItem;
                    case RIGHT_HAND -> animatable.isLeftHanded() ?
                            ThursdayMorningPiglinRenderer.this.offhandItem : ThursdayMorningPiglinRenderer.this.mainHandItem;
                    default -> null;
                };
            }

            @Override
            protected ModelTransformation.Mode getTransformTypeForStack(GeoBone bone, ItemStack stack, ThursdayMorningPiglin animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND;
                    default -> ModelTransformation.Mode.NONE;
                };
            }
            // Do some quick render modifications depending on what the item is
            @Override
            protected void renderStackForBone(MatrixStack matrixStack, GeoBone bone, ItemStack stack, ThursdayMorningPiglin animatable,
                                              VertexConsumerProvider vertexConsumerProvider, float partialTick, int packedLight, int packedOverlay) {
                if (stack == ThursdayMorningPiglinRenderer.this.mainHandItem) {
                    //matrixStack.multiply(new Quaternionf(-90f, 0, 0, 1));

                    if (stack.getItem() instanceof ShieldItem)
                        matrixStack.translate(0, 0.125, -0.25);
                }
                else if (stack == ThursdayMorningPiglinRenderer.this.offhandItem) {
                    matrixStack.multiply(new Quaternionf(-90f, 0, 0, 1));

                    if (stack.getItem() instanceof ShieldItem) {
                        matrixStack.translate(0, 0.125, 0.25);
                        matrixStack.multiply(new Quaternionf(0, 180, 0, 1));
                    }
                }

                super.renderStackForBone(matrixStack, bone, stack, animatable, vertexConsumerProvider, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Override
    public Identifier getTextureLocation(ThursdayMorningPiglin animatable) {
        return new Identifier(TheDumbass.MOD_ID, "textures/entity/tmp/tmp.png");
    }

    @Override
    public RenderLayer getRenderType(ThursdayMorningPiglin animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

    @Override
    public void preRender(MatrixStack matrixStack, ThursdayMorningPiglin animatable, BakedGeoModel model, VertexConsumerProvider vertexConsumerProvider, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(matrixStack, animatable, model, vertexConsumerProvider, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        this.mainHandItem = animatable.getMainHandStack();
        this.offhandItem = animatable.getOffHandStack();
    }
}
