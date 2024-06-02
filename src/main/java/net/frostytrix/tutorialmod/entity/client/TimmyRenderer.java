package net.frostytrix.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.entity.custom.TimmyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TimmyRenderer extends MobRenderer<TimmyEntity, TimmyModel<TimmyEntity>> {
    public TimmyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TimmyModel<>(pContext.bakeLayer(ModModelLayers.TIMMY_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TimmyEntity timmyEntity) {
        return new ResourceLocation(TutorialModTest.MODID, "textures/entity/timmy.png");
    }

    @Override
    public void render(TimmyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
