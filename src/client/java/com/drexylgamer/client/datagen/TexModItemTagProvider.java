package com.drexylgamer.client.datagen;

import com.drexylgamer.item.ModItemIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class TexModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> HEAD_ARMOR = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("head_armor"));
    public static final TagKey<Item> CHEST_ARMOR = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("chest_armor"));
    public static final TagKey<Item> LEG_ARMOR = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("leg_armor"));
    public static final TagKey<Item> FOOT_ARMOR = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("foot_armor"));
    public static final TagKey<Item> AXES = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("axes"));
    public static final TagKey<Item> HOES = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("hoes"));
    public static final TagKey<Item> PICKAXES = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("pickaxes"));
    public static final TagKey<Item> SHOVELS = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("shovels"));
    public static final TagKey<Item> SWORDS = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("swords"));
    public static final TagKey<Item> SPEARS = TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("spears"));


    public TexModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(HEAD_ARMOR)
                .add(ModItemIds.GAY_HELMET);
        builder(CHEST_ARMOR)
                .add(ModItemIds.GAY_CHESTPLATE);
        builder(LEG_ARMOR)
                .add(ModItemIds.GAY_LEGGINGS);
        builder(FOOT_ARMOR)
                .add(ModItemIds.GAY_BOOTS);
        builder(AXES)
                .add(ModItemIds.GAY_AXE);
        builder(HOES)
                .add(ModItemIds.GAY_HOE);
        builder(PICKAXES)
                .add(ModItemIds.GAY_PICKAXE);
        builder(SHOVELS)
                .add(ModItemIds.GAY_SHOVEL);
        builder(SWORDS)
                .add(ModItemIds.GAY_SWORD);
        builder(SPEARS)
                .add(ModItemIds.GAY_SPEAR);    }
}
