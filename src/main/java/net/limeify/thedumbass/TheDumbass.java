package net.limeify.thedumbass;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.limeify.thedumbass.entity.DumbassEntities;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;
import net.limeify.thedumbass.item.DumbassItems;

import static net.limeify.thedumbass.item.DumbassItemGroup.DUMBASS_WEAPONS;
import static net.limeify.thedumbass.item.DumbassItems.SWORD_CANE;

public class TheDumbass implements ModInitializer
{
	public static final String MOD_ID = "thedumbass";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(DumbassEntities.THURSDAY_MORNING_PIGLIN, ThursdayMorningPiglin.createPiglinAttributes());

		DumbassItems.registerDumbassItems();
		ItemGroupEvents.modifyEntriesEvent(DUMBASS_WEAPONS).register(content -> content.add(SWORD_CANE));
	}
}
