package com.drexylgamer.client.entity;

import com.drexylgamer.Texmod;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModEntityModelLayers {
    public static final ModelLayerLocation GAY_MITE = createMain("gay_mite");

    public static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Texmod.id(name), "main");
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.GAY_MITE, GayMiteEntityModel::getTexturedModelData);
    }
}
