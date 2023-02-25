package net.limeify.thedumbass.entity.client;

import net.limeify.thedumbass.TheDumbass;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThursdayMorningPiglinRenderer extends GeoEntityRenderer<ThursdayMorningPiglin>
{
    public ThursdayMorningPiglinRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ThursdayMorningPiglinModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(ThursdayMorningPiglin animatable) {
        return new Identifier(TheDumbass.MOD_ID, "textures/entity/tmp/tmp.png");
    }

    @Override
    public RenderLayer getRenderType(ThursdayMorningPiglin animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
