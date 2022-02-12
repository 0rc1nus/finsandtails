
package teamdraco.finsandstails.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.finsandtails.geckolib3.renderers.geo.GeoProjectilesRenderer;
import teamdraco.finsandstails.client.model.TealArrowfishArrowModel;
import teamdraco.finsandstails.common.entities.item.TealArrowfishArrowEntity;

public class TealArrowfishArrowRenderer extends GeoProjectilesRenderer<TealArrowfishArrowEntity> {

    public TealArrowfishArrowRenderer(EntityRendererProvider.Context context) {
        super(context, new TealArrowfishArrowModel());
    }

    @Override
    public void render(TealArrowfishArrowEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.yRot) - 90.0F));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.xRot) + 90.0F));
        matrixStackIn.translate(0.0, -1.3f, 0);
        float f9 = (float) entityIn.shakeTime - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f10));
        }

        matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);

        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}