package net.limeify.thedumbass.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.limeify.thedumbass.TheDumbass;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class DumbassItemGroup
{
    public static final ItemGroup DUMBASS_WEAPONS = FabricItemGroup.builder(new Identifier(TheDumbass.MOD_ID, "dumbassweapons")).build();
}
