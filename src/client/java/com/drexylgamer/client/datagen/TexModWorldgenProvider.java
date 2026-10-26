package com.drexylgamer.client.datagen;

import com.drexylgamer.client.TexmodClient;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class TexModWorldgenProvider extends FabricDynamicRegistryProvider {
    public static final Logger LOGGER = LoggerFactory.getLogger(TexmodClient.ID);
    public TexModWorldgenProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        LOGGER.info("Configuring Worldgen");
        entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));
        LOGGER.info("Successfully Configured Worldgen");
    }

    @Override
    public String getName() {
        return "World Generation";
    }
}
