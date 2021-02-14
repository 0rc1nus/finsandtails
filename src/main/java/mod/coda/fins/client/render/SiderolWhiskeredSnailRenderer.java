package mod.coda.fins.client.render;

import mod.coda.fins.FinsAndTails;
import mod.coda.fins.client.model.SiderolWhiskeredSnailModel;
import mod.coda.fins.entities.SiderolWhiskeredSnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SiderolWhiskeredSnailRenderer extends MobRenderer<SiderolWhiskeredSnailEntity, SiderolWhiskeredSnailModel<SiderolWhiskeredSnailEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/siderol_whiskered_snail.png");

    public SiderolWhiskeredSnailRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SiderolWhiskeredSnailModel<>(), 0.25F);
    }

    public ResourceLocation getEntityTexture(SiderolWhiskeredSnailEntity entity) {
        return TEXTURE;
    }
}