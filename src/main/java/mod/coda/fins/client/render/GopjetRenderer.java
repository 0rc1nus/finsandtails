package mod.coda.fins.client.render;

import mod.coda.fins.FinsAndTails;
import mod.coda.fins.client.model.GopjetModel;
import mod.coda.fins.entities.GopjetEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GopjetRenderer extends MobRenderer<GopjetEntity, GopjetModel<GopjetEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/gopjet/standard.png");
    private static final ResourceLocation BOOSTING_TEXTURE = new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/gopjet/boosting.png");

    public GopjetRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GopjetModel<>(), 0.3F);
    }

    public ResourceLocation getEntityTexture(GopjetEntity entity) {
        return entity.isBoosting() ? BOOSTING_TEXTURE : TEXTURE;
    }
}