package com.drexylgamer.item;

import com.drexylgamer.ModMobEffects;
import com.drexylgamer.block.ModBlocks;
import com.drexylgamer.tag.ModArmorMaterials;
import com.drexylgamer.tag.ModToolMaterial;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    public static final Consumable GAY_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModMobEffects.GAYNESS, 15 * 20, 1), 1.0f))
            .build();
    public static final FoodProperties GAY_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();


    public static final Item GAY_DUST = register(
            ModItemIds.GAY_DUST,
            Item::new,
            new Item.Properties()
    );

    public static final Item PURE_CRYSTALLISED_GAY = register(
            ModItemIds.PURE_CRYSTALLISED_GAY,
            Item::new,
            new Item.Properties().food(GAY_FOOD_COMPONENT, GAY_FOOD_CONSUMABLE_COMPONENT)
    );

    public static final Item GAY_CRYSTALS = register(
            ModItemIds.GAY_CRYSTALS,
            Item::new,
            new Item.Properties()
    );

    public static final Item GAY_INGOT = register(
            ModItemIds.GAY_INGOT,
            Item::new,
            new Item.Properties()
    );

    public static final Item RAW_GAY = register(
            ModItemIds.RAW_GAY,
            Item::new,
            new Item.Properties()
    );

    public static final Item HAMMER = register(
            ModItemIds.HAMMER,
            HammerItem::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON, 1.0F, -2.8F)
    );

    public static final Item GAY_AXE = register(
            ModItemIds.GAY_AXE,
            Item::new,
            new Item.Properties().axe(ModToolMaterial.GAY, 5.0F, -3.0F)
    );

    public static final Item GAY_HOE = register(
            ModItemIds.GAY_HOE,
            Item::new,
            new Item.Properties().hoe(ModToolMaterial.GAY, -4.0F, 0.0F)
    );

    public static final Item GAY_PICKAXE = register(
            ModItemIds.GAY_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ModToolMaterial.GAY, 1.0F, -2.8F)
    );

    public static final Item GAY_SHOVEL = register(
            ModItemIds.GAY_SHOVEL,
            Item::new,
            new Item.Properties().shovel(ModToolMaterial.GAY, 1.5F, -3.0F)
    );

    public static final Item GAY_SWORD = register(
            ModItemIds.GAY_SWORD,
            Item::new,
            new Item.Properties().sword(ModToolMaterial.GAY, 3.0F, -2.4F)
    );

    public static final Item GAY_SPEAR = register(
            ModItemIds.GAY_SPEAR,
            Item::new,
            new Item.Properties().spear(ModToolMaterial.GAY, 1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)
    );

    public static final Item GAY_HELMET = register(
            ModItemIds.GAY_HELMET,
            Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.GAY, ArmorType.HELMET)
    );

    public static final Item GAY_CHESTPLATE = register(
            ModItemIds.GAY_CHESTPLATE,
            Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.GAY, ArmorType.CHESTPLATE)
    );

    public static final Item GAY_LEGGINGS = register(
            ModItemIds.GAY_LEGGINGS,
            Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.GAY, ArmorType.LEGGINGS)
    );

    public static final Item GAY_BOOTS = register(
            ModItemIds.GAY_BOOTS,
            Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.GAY, ArmorType.BOOTS)
    );


    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_DUST));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_INGOT));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.RAW_GAY));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_HOE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_SHOVEL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.HAMMER));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(ModBlocks.BLOCK_OF_GAY));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(ModBlocks.GAY_ORE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(ModBlocks.GAY_DEEPSLATE_ORE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.PURE_CRYSTALLISED_GAY));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_SWORD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_SPEAR));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.GAY_BOOTS));
    }
}
