package com.drexylgamer.client.datagen;

import com.drexylgamer.block.ModBlockIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class TexModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> NEEDS_IRON_TOOL = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("needs_iron_tool"));
    public static final TagKey<Item> NEEDS_DIAMOND_TOOL = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("needs_diamond_tool"));
    public static final TagKey<Item> MINEABLE_PICKAXE = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("mineable/pickaxe"));

    public TexModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(NEEDS_IRON_TOOL)
                .add(ModBlockIds.GAY_ORE)
                .add(ModBlockIds.BLOCK_OF_GAY)
                .setReplace(false);
        builder(NEEDS_DIAMOND_TOOL)
                .add(ModBlockIds.GAY_DEEPSLATE_ORE)
                .setReplace(false);
        builder(MINEABLE_PICKAXE)
                .add(ModBlockIds.GAY_DEEPSLATE_ORE)
                .add(ModBlockIds.GAY_ORE)
                .add(ModBlockIds.BLOCK_OF_GAY)
                .setReplace(false);
    }
}
