package net.limeify.thedumbass.entity.client;

import net.limeify.thedumbass.TheDumbass;
import net.limeify.thedumbass.entity.custom.ThursdayMorningPiglin;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ThursdayMorningPiglinModel extends DefaultedEntityGeoModel<ThursdayMorningPiglin> {
    public ThursdayMorningPiglinModel() {
        super(new Identifier(TheDumbass.MOD_ID, "tmp/tmp"), true);
    }
}
