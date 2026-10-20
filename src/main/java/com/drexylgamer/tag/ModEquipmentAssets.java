package com.drexylgamer.tag;

import com.drexylgamer.Texmod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public interface ModEquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = EquipmentAssets.ROOT_ID;

    ResourceKey<EquipmentAsset> GAY = createId("gay");

    static ResourceKey<EquipmentAsset> createId(final String name) {
        return ResourceKey.create(ROOT_ID, Texmod.id(name));
    }
}
