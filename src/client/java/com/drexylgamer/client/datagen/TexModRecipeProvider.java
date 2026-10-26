package com.drexylgamer.client.datagen;

import com.drexylgamer.block.ModBlocks;
import com.drexylgamer.client.TexmodClient;
import com.drexylgamer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TexModRecipeProvider extends FabricRecipeProvider {
    public static final Logger LOGGER = LoggerFactory.getLogger(TexmodClient.ID);
    public TexModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        LOGGER.info("Creating Recipes");
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {

                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                // GAY INGOT
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.GAY_INGOT, 9)
                        .requires(ModBlocks.BLOCK_OF_GAY)
                        .unlockedBy(getHasName(ModBlocks.BLOCK_OF_GAY), has(ModBlocks.BLOCK_OF_GAY))
                        .save(output);
                // BLOCK OF GAY
                shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_GAY)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModItems.GAY_INGOT)
                        .group("block_of_gay")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                // HAMMER
                shaped(RecipeCategory.MISC, ModItems.HAMMER)
                        .pattern("  #")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('#', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("hammer")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                // GAY DUST
                shapeless(RecipeCategory.MISC, ModItems.GAY_DUST)
                        .requires(ModItems.GAY_INGOT)
                        .requires(ModItems.HAMMER)
                        .unlockedBy(getHasName(ModItems.HAMMER), has(ModItems.HAMMER))
                        .save(output);
                // PURE CRYSTALLISED GAY
                shapeless(RecipeCategory.MISC, ModItems.PURE_CRYSTALLISED_GAY)
                        .requires(ModItems.GAY_CRYSTALS)
                        .requires(ModItems.HAMMER)
                        .unlockedBy(getHasName(ModItems.GAY_CRYSTALS), has(ModItems.GAY_CRYSTALS))
                        .save(output);
                // GAY INGOT SMELTING
                oreSmelting(
                        List.of(ModItems.RAW_GAY),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        300,
                        "gay_ingot"
                );
                oreBlasting(
                        List.of(ModItems.RAW_GAY),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        200,
                        "gay_ingot"
                );
                oreBlasting(
                        List.of(ModBlocks.GAY_DEEPSLATE_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        230,
                        "gay_ingot"
                );
                oreSmelting(
                        List.of(ModBlocks.GAY_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        300,
                        "gay_ingot"
                );
                oreBlasting(
                        List.of(ModBlocks.GAY_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        200,
                        "gay_ingot"
                );
                oreSmelting(
                        List.of(ModBlocks.GAY_DEEPSLATE_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.GAY_INGOT,
                        0.1f,
                        330,
                        "gay_ingot"
                );
                // Crystalliser
                shaped(RecipeCategory.MISC, ModBlocks.CRYSTALLISER)
                        .pattern("IGI")
                        .pattern("G#G")
                        .pattern("III")
                        .define('I', Blocks.IRON_BLOCK)
                        .define('G', Blocks.GLASS)
                        .define('#', ModItems.GAY_INGOT)
                        .group("crystalliser")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                // Gay Tools and Combat
                shaped(RecipeCategory.MISC, ModItems.GAY_AXE)
                        .pattern("** ")
                        .pattern("*S ")
                        .pattern(" S ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_axe")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GAY_HOE)
                        .pattern("** ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_hoe")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GAY_PICKAXE)
                        .pattern("***")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_pickaxe")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GAY_SHOVEL)
                        .pattern(" * ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_shovel")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GAY_SWORD)
                        .pattern(" * ")
                        .pattern(" * ")
                        .pattern(" S ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_sword")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GAY_SPEAR)
                        .pattern("  *")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('*', ModItems.GAY_INGOT)
                        .define('S', Items.STICK)
                        .group("gay_spear")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                // Gay Armor
                shaped(RecipeCategory.COMBAT, ModItems.GAY_HELMET)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("   ")
                        .define('#', ModItems.GAY_INGOT)
                        .group("gay_helmet")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.GAY_CHESTPLATE)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModItems.GAY_INGOT)
                        .group("gay_chestplate")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.GAY_LEGGINGS)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.GAY_INGOT)
                        .group("gay_leggings")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.GAY_BOOTS)
                        .pattern("   ")
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.GAY_INGOT)
                        .group("gay_boots")
                        .unlockedBy(getHasName(ModItems.GAY_INGOT), has(ModItems.GAY_INGOT))
                        .save(output);
            LOGGER.info("Successfully Created Recipes");
            }
        };

    }

    @Override
    public String getName() {
        return "TexModRecipeProvider";
    }

}
