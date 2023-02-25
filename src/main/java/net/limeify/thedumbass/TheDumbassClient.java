package net.limeify.thedumbass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.limeify.thedumbass.entity.ModEntities;
import net.limeify.thedumbass.entity.client.ThursdayMorningPiglinRenderer;

public class TheDumbassClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.THURSDAY_MORNING_PIGLIN, ThursdayMorningPiglinRenderer::new);
    }
}
