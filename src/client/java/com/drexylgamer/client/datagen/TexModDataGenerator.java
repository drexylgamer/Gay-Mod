package com.drexylgamer.client.datagen;

import com.drexylgamer.TexModConfiguredFeatures;
import com.drexylgamer.TexModPlacedFeatures;
import com.drexylgamer.client.TexmodClient;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TexModDataGenerator implements DataGeneratorEntrypoint {
    public static final Logger LOGGER = LoggerFactory.getLogger(TexmodClient.ID);
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        LOGGER.info("Initializing Data Generator");
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        LOGGER.info("Adding Datagen Providers");
        pack.addProvider(TexModEnglishLanguageProvider::new);
        pack.addProvider(TexModModelProvider::new);
        pack.addProvider(TexModRecipeProvider::new);
        pack.addProvider(TexModBlockLootTableProvider::new);
        pack.addProvider(TexModWorldgenProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<TexModEquipmentAssetProvider>) TexModEquipmentAssetProvider::new);
        pack.addProvider(TexModItemTagProvider::new);
        pack.addProvider(TexModBlockTagProvider::new);
        pack.addProvider(TexModEntityLootTableProvider::new);
        LOGGER.info("Successfully Added Datagen Providers");
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TexModConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, TexModPlacedFeatures::configure);
    }
}
