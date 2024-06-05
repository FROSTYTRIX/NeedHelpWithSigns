package net.frostytrix.tutorialmod.entity.custom;

import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.entity.ModEntities;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class CoinProjectileEntity extends ThrowableItemProjectile {
    public CoinProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public CoinProjectileEntity(Level pLevel) {
        super(ModEntities.COIN_PROJECTILE.get(), pLevel);
    }

    public CoinProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.COIN_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.COIN.get();
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        pResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 1F);
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        BlockPos Pos = pResult.getBlockPos();
        if (!level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().addFreshEntity(new ItemEntity(level(), Pos.getX(), Pos.getY()+1, Pos.getZ(), new ItemStack(ModItems.COIN.get())));
            this.discard();
        }
    }
}
