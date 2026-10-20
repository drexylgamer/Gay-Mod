package com.drexylgamer;

import com.drexylgamer.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class TexModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GAY_ORE_VEIN_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Texmod.id("gay_ore_vein")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GAY_DEEPSLATE_ORE_VEIN_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Texmod.id("gay_deepslate_ore_vein")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest stoneReplaceableRule = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> gayOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, ModBlocks.GAY_ORE.defaultBlockState())
                );
        List<OreConfiguration.TargetBlockState> gayDeepslateOreConfig =
                List.of(
                        OreConfiguration.target(deepslateReplaceableRule, ModBlocks.GAY_DEEPSLATE_ORE.defaultBlockState())
                );
        context.register(
                GAY_ORE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(gayOreConfig, 2)
                )
        );

        context.register(
                GAY_DEEPSLATE_ORE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(gayDeepslateOreConfig, 4)
                )
        );
    }
}
