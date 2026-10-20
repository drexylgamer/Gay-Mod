package com.drexylgamer;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

import static com.drexylgamer.Texmod.MOD_ID;

public class ModMobEffects {
    public static final Holder.Reference<MobEffect> TALLNESS = registerMobEffect("tallness", new TallnessEffect());
    public static final Holder.Reference<MobEffect> GAYNESS = registerMobEffect("gay", new GayEffect());

    private static Holder.Reference<MobEffect> registerMobEffect(String name, MobEffect effect) {

        return Registry.registerForHolder(
                BuiltInRegistries.MOB_EFFECT, // This supplies the Registry<MobEffect> instance directly
                Identifier.fromNamespaceAndPath(MOD_ID, name), // Matches your Identifier/ResourceLocation parameter
                effect
        );
    }

    public static void initialize() {

    }

}
