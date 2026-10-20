package com.drexylgamer;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class TexModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> GAY_ORE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Texmod.id("gay_ore_placed")
            );

    public static final ResourceKey<PlacedFeature> GAY_DEEPSLATE_ORE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Texmod.id("gay_deepslate_ore_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        List<PlacementModifier> gayOreVeinModifiers = List.of(
                CountPlacement.of(4),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(25)))
        );

        List<PlacementModifier> gayDeepslateOreVeinModifiers = List.of(
                CountPlacement.of(4),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0)))
        );

        context.register(
                GAY_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(TexModConfiguredFeatures.GAY_ORE_VEIN_CONFIGURED_KEY),
                        gayOreVeinModifiers
                )
        );

        context.register(
                GAY_DEEPSLATE_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(TexModConfiguredFeatures.GAY_DEEPSLATE_ORE_VEIN_CONFIGURED_KEY),
                        gayDeepslateOreVeinModifiers
                )
        );
    }
}
