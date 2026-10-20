package com.drexylgamer;

import com.drexylgamer.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class GayEffect extends MobEffect {
    public GayEffect() {
        super(MobEffectCategory.BENEFICIAL, 3402750);
    }

    @Override
    public boolean applyEffectTick(@NonNull ServerLevel serverLevel, LivingEntity mob, int amplification) {
            BlockPos blockBelow = mob.getOnPos();

        if (serverLevel.getBlockState(blockBelow).is(Blocks.DIAMOND_BLOCK)) {
            BlockState gayState = ModBlocks.BLOCK_OF_GAY.defaultBlockState();

            serverLevel.setBlock(blockBelow, gayState, 3);
        }


        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
