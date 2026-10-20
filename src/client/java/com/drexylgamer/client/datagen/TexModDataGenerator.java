package com.drexylgamer.client.datagen;

import com.drexylgamer.TexModConfiguredFeatures;
import com.drexylgamer.TexModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class TexModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TexModEnglishLanguageProvider::new);
        pack.addProvider(TexModModelProvider::new);
        pack.addProvider(TexModRecipeProvider::new);
        pack.addProvider(TexModBlockLootTableProvider::new);
        pack.addProvider(TexModWorldgenProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<TexModEquipmentAssetProvider>) TexModEquipmentAssetProvider::new);
        pack.addProvider(TexModItemTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TexModConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, TexModPlacedFeatures::configure);
    }
}
