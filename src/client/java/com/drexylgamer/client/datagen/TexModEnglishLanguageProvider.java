package com.drexylgamer.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TexModEnglishLanguageProvider  extends FabricLanguageProvider {
    public TexModEnglishLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.texmod.gay_dust", "Gay Dust");
        translationBuilder.add("item.texmod.gay_ingot", "Gay Ingot");
        translationBuilder.add("item.texmod.hammer", "Hammer");
        translationBuilder.add("item.texmod.gay_axe", "Gay Axe");
        translationBuilder.add("item.texmod.gay_hoe", "Gay Hoe");
        translationBuilder.add("item.texmod.gay_pickaxe", "Gay Pickaxe");
        translationBuilder.add("item.texmod.gay_shovel", "Gay Shovel");
        translationBuilder.add("item.texmod.gay_sword", "Gay Sword");
        translationBuilder.add("item.texmod.gay_spear", "Gay Spear");
        translationBuilder.add("item.texmod.raw_gay", "Raw Gay");
        translationBuilder.add("block.texmod.block_of_gay", "Block Of Gay");
        translationBuilder.add("block.texmod.gay_ore", "Gay Ore");
        translationBuilder.add("block.texmod.gay_deepslate_ore", "Gay Deepslate Ore");
        translationBuilder.add("block.texmod.crystalliser", "Crystalliser");
        translationBuilder.add("item.texmod.pure_crystallised_gay", "Pure Crystalised Gay");
        translationBuilder.add("item.texmod.gay_crystals", "Gay Crystals");
        translationBuilder.add("effect.texmod.gay", "Gay");
        translationBuilder.add("item.texmod.gay_helmet", "Gay Helmet");
        translationBuilder.add("item.texmod.gay_chestplate", "Gay Chestplate");
        translationBuilder.add("item.texmod.gay_leggings", "Gay Leggings");
        translationBuilder.add("item.texmod.gay_boots", "Gay Boots");
    }
}
