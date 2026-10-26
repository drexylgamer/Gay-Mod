package com.drexylgamer.entity;

import com.drexylgamer.Texmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeIds {
    public static ResourceKey<EntityType<?>> GAY_MITE = create("gay_mite");

    private static ResourceKey<EntityType<?>> create(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Texmod.id(name));
    }

}
