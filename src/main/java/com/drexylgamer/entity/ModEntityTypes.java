package com.drexylgamer.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.slf4j.Logger;


public class ModEntityTypes {
    public static final EntityType<GayMiteEntity> GAY_MITE = register(
            ModEntityTypeIds.GAY_MITE,
            EntityType.Builder.<GayMiteEntity>of(GayMiteEntity::new, MobCategory.CREATURE)
                    .sized(0.75F, 1.75F),
            GayMiteEntity.createGayMiteAttributes()
    );

    private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    private static <T extends LivingEntity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder, AttributeSupplier.Builder attributes) {
        EntityType<T> type = register(key, builder);
        FabricDefaultAttributeRegistry.register(type, attributes);
        return type;
    }

    public static void initialize(Logger LOGGER) {
        LOGGER.info("Initializing ModEntityTypes");
        LOGGER.info("Successfully Initialized ModEntityTypes");
    }
}
