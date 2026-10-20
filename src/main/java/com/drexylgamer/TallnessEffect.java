package com.drexylgamer;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class TallnessEffect extends MobEffect {
    public TallnessEffect() {
        super(MobEffectCategory.BENEFICIAL, 3402751);
        this.addAttributeModifier(
                Attributes.NAME_TAG_DISTANCE,
                Identifier.withDefaultNamespace("effect.tallness"),
                1d,
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }
}
