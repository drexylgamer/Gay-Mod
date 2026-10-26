package com.drexylgamer;

import com.drexylgamer.block.CrystallisingRecipe;
import com.drexylgamer.block.ModBlocks;
import com.drexylgamer.entity.ModEntityTypes;
import com.drexylgamer.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Texmod implements ModInitializer {
	public static final String MOD_ID = "texmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		LOGGER.info("Initializing Mod");
		ModItems.initialize(LOGGER);
		ModBlocks.initialize(LOGGER);
		ModMobEffects.initialize(LOGGER);
		ModEntityTypes.initialize(LOGGER);

		RecipeSynchronization.synchronizeRecipeSerializer(CRYSTALLISING_RECIPE_SERIALIZER);

		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				TexModPlacedFeatures.GAY_ORE_PLACED_KEY
		);
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				TexModPlacedFeatures.GAY_DEEPSLATE_ORE_PLACED_KEY
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static final RecipeSerializer<CrystallisingRecipe> CRYSTALLISING_RECIPE_SERIALIZER = Registry.register(
			BuiltInRegistries.RECIPE_SERIALIZER,
			Texmod.id("crystallising"),
			new RecipeSerializer<>(CrystallisingRecipe.CODEC, CrystallisingRecipe.STREAM_CODEC)
	);

	public static final RecipeType<CrystallisingRecipe> CRYSTALLISING_RECIPE_TYPE = Registry.register(
			BuiltInRegistries.RECIPE_TYPE,
			Texmod.id("crystallising"),
			new RecipeType<CrystallisingRecipe>() { }
	);
}
