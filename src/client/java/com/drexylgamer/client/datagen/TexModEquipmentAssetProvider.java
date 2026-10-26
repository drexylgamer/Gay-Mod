package com.drexylgamer.client.datagen;

import com.drexylgamer.Texmod;
import com.drexylgamer.client.TexmodClient;
import com.drexylgamer.tag.ModEquipmentAssets;
import com.mojang.serialization.Codec;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class TexModEquipmentAssetProvider extends EquipmentAssetProvider {
    public static final Logger LOGGER = LoggerFactory.getLogger(TexmodClient.ID);
    private final PackOutput.PathProvider pathProvider;

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        LOGGER.info("Providing EquipmentAssets");
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + String.valueOf(id));
            }
        });
        Codec var10001 = EquipmentClientInfo.CODEC;
        PackOutput.PathProvider var10002 = this.pathProvider;
        Objects.requireNonNull(var10002);
        LOGGER.info("Successfully Provided EquipmentAssets");
        return DataProvider.saveAll(cache, var10001, var10002::json, equipmentAssets);
    }


    public TexModEquipmentAssetProvider(PackOutput output) {
        super(output);
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(final BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(ModEquipmentAssets.GAY, onlyHumanoid("gay"));
    }

    private static EquipmentClientInfo onlyHumanoid(final String name) {
        return EquipmentClientInfo.builder().addHumanoidLayers(Texmod.id(name)).build();
    }
}
