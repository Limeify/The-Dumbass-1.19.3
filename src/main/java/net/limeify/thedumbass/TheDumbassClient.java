package net.limeify.thedumbass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.limeify.thedumbass.entity.DumbassEntities;
import net.limeify.thedumbass.entity.client.renderer.ThursdayMorningPiglinRenderer;

public class TheDumbassClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(DumbassEntities.THURSDAY_MORNING_PIGLIN, ThursdayMorningPiglinRenderer::new);
    }
}
