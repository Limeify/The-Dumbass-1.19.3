package net.limeify.thedumbass;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.limeify.thedumbass.entity.ModEntities;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class TheDumbass implements ModInitializer {
	public static final String MOD_ID = "thedumbass";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//wj7ahruyhr
	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.THURSDAY_MORNING_PIGLIN, ThursdayMorningPiglin.createPiglinAttributes());
	}
}
