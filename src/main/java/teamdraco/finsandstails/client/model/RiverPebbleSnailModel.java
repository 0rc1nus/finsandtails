package teamdraco.finsandstails.client.model;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import teamdraco.finsandstails.FinsAndTails;
import teamdraco.finsandstails.common.entities.RiverPebbleSnailEntity;

import java.util.Map;

public class RiverPebbleSnailModel extends AnimatedGeoModel<RiverPebbleSnailEntity> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/river_pebble_snail/river_pebble_snail_1.png"));
        hashMap.put(1, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/river_pebble_snail/river_pebble_snail_2.png"));
        hashMap.put(2, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/river_pebble_snail/river_pebble_snail_3.png"));
        hashMap.put(3, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/river_pebble_snail/river_pebble_snail_4.png"));
        hashMap.put(4, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/river_pebble_snail/river_pebble_snail_5.png"));
    });

    @Override
    public ResourceLocation getModelResource(RiverPebbleSnailEntity wee) {
        return new ResourceLocation(FinsAndTails.MOD_ID, "geo/entity/river_pebble_snail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RiverPebbleSnailEntity wee) {
        return TEXTURES.getOrDefault(wee.getVariant(), TEXTURES.get(0));
    }

    @Override
    public ResourceLocation getAnimationResource(RiverPebbleSnailEntity wee) {
        return new ResourceLocation(FinsAndTails.MOD_ID, "animations/entity/river_pebble_snail.animations.json");
    }

    @Override
    public void setCustomAnimations(RiverPebbleSnailEntity entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("body");
        IBone shell = this.getAnimationProcessor().getBone("shell");

        if (entity.isBaby()) {
            body.setScaleX(0.5F);
            body.setScaleY(0.5F);
            body.setScaleZ(0.5F);
            body.setPositionY(-1F);

            shell.setScaleX(0.65F);
            shell.setScaleY(0.65F);
            shell.setScaleZ(0.65F);
            shell.setPositionY(-0.25F);
        }
    }
}
