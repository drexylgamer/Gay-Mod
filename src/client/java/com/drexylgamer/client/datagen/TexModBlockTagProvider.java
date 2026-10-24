package com.drexylgamer.client.datagen;

import com.drexylgamer.block.ModBlockIds;
import com.drexylgamer.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class TexModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public static final TagKey<Block> NEEDS_DIAMOND_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("needs_diamond_tool"));
    public static final TagKey<Block> NEEDS_GAY_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("needs_gay_tool"));
    public static final TagKey<Block> MINEABLE_PICKAXE = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("mineable/pickaxe"));
    public static final TagKey<Block> INCORRECT_FOR_NETHERITE_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("incorrect_for_netherite_tool"));
    public static final TagKey<Block> INCORRECT_FOR_DIAMOND_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("incorrect_for_diamond_tool"));
    public TexModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(INCORRECT_FOR_NETHERITE_TOOL)
                .addOptionalTag(ModTags.NEEDS_GAY_TOOL).setReplace(true);
        builder(INCORRECT_FOR_DIAMOND_TOOL)
                .addOptionalTag(ModTags.NEEDS_GAY_TOOL).setReplace(true);
        builder(NEEDS_DIAMOND_TOOL)
                .add(ModBlockIds.GAY_ORE)
                .add(ModBlockIds.BLOCK_OF_GAY)
                .setReplace(false);
        builder(MINEABLE_PICKAXE)
                .add(ModBlockIds.GAY_ORE)
                .add(ModBlockIds.BLOCK_OF_GAY)
                .add(ModBlockIds.GAY_DEEPSLATE_ORE)
                .setReplace(false);
        builder(NEEDS_GAY_TOOL)
                .add(ModBlockIds.GAY_DEEPSLATE_ORE)
                .setReplace(false);
    }
}
