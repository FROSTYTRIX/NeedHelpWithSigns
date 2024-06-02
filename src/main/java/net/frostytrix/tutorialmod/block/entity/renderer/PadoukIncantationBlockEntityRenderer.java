package net.frostytrix.tutorialmod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.frostytrix.tutorialmod.block.entity.PadoukIncantationTableEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class PadoukIncantationBlockEntityRenderer implements BlockEntityRenderer<PadoukIncantationTableEntity> {
    public PadoukIncantationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PadoukIncantationTableEntity pBlockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource Buffer, int pPackedLight, int pPackedOverlay) {

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();

        poseStack.pushPose();
        poseStack.translate(0.5f,1.2f,0.5f);
        poseStack.scale(0.35f,0.35f,0.35f);


        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, poseStack, Buffer, pBlockEntity.getLevel(), 1);
            poseStack.popPose();
    }
    private int getLightLevel(Level level, BlockPos pos){
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
