package com.drexylgamer.client.datagen;

import com.drexylgamer.Texmod;
import com.drexylgamer.block.ModBlocks;
import com.drexylgamer.item.ModItems;
import com.drexylgamer.tag.ModEquipmentAssets;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class TexModModelProvider extends FabricModelProvider {
    public TexModModelProvider(FabricPackOutput output) {
        super(output);

    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        blockModelGenerator.createTrivialCube(ModBlocks.BLOCK_OF_GAY);
        blockModelGenerator.createTrivialCube(ModBlocks.GAY_ORE);
        blockModelGenerator.createTrivialBlock(ModBlocks.GAY_DEEPSLATE_ORE, TexturedModel.COLUMN_ALT);
        blockModelGenerator.createAnvil(ModBlocks.CRYSTALLISER);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.GAY_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_GAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PURE_CRYSTALLISED_GAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HAMMER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_AXE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_HOE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_PICKAXE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_SHOVEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_SWORD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_SPEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GAY_BOOTS, ModelTemplates.FLAT_ITEM);
    }
}
