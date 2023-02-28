package net.limeify.thedumbass.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.limeify.thedumbass.TheDumbass;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DumbassEntities
{
    public static final EntityType<ThursdayMorningPiglin> THURSDAY_MORNING_PIGLIN = Registry.register(Registries.ENTITY_TYPE, new Identifier(TheDumbass.MOD_ID, "tmp"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ThursdayMorningPiglin::new).dimensions(EntityDimensions.fixed(0.5f, 2)).build());
}
