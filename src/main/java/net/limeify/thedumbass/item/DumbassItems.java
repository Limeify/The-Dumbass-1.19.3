package net.limeify.thedumbass.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.limeify.thedumbass.TheDumbass;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DumbassItems
{
    public static final Item SWORD_CANE = registerItem("swordcane", new SwordItem(ToolMaterials.NETHERITE, 2, -2, new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TheDumbass.MOD_ID, name), item);
    }

    public static void registerDumbassItems()
    {
        TheDumbass.LOGGER.debug("Registering items for " + TheDumbass.MOD_ID);
    }
}
