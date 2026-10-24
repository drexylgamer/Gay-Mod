package com.drexylgamer.item;

import com.drexylgamer.Texmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    public static final ResourceKey<Item> GAY_DUST = createItem("gay_dust");
    public static final ResourceKey<Item> PURE_CRYSTALLISED_GAY = createItem("pure_crystallised_gay");
    public static final ResourceKey<Item> GAY_CRYSTALS = createItem("gay_crystals");
    public static final ResourceKey<Item> GAY_INGOT = createItem("gay_ingot");
    public static final ResourceKey<Item> RAW_GAY = createItem("raw_gay");
    public static final ResourceKey<Item> HAMMER = createItem("hammer");

    public static final ResourceKey<Item> GAY_AXE = createItem("gay_axe");
    public static final ResourceKey<Item> GAY_HOE = createItem("gay_hoe");
    public static final ResourceKey<Item> GAY_PICKAXE = createItem("gay_pickaxe");
    public static final ResourceKey<Item> GAY_SHOVEL = createItem("gay_shovel");

    public static final ResourceKey<Item> GAY_SWORD = createItem("gay_sword");
    public static final ResourceKey<Item> GAY_SPEAR = createItem("gay_spear");

    public static final ResourceKey<Item> GAY_HELMET = createItem("gay_helmet");
    public static final ResourceKey<Item> GAY_CHESTPLATE = createItem("gay_chestplate");
    public static final ResourceKey<Item> GAY_LEGGINGS = createItem("gay_leggings");
    public static final ResourceKey<Item> GAY_BOOTS = createItem("gay_boots");


    public static ResourceKey<Item> createItem(String name) {
        return ResourceKey.create(Registries.ITEM, Texmod.id(name));
    }
}
