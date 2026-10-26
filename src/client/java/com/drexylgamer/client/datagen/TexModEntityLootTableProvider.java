package com.drexylgamer.client.datagen;

import com.drexylgamer.entity.ModEntityTypes;
import com.drexylgamer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class TexModEntityLootTableProvider extends FabricEntityLootSubProvider {

    protected TexModEntityLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        add(ModEntityTypes.GAY_MITE, new LootTable.Builder()
                .withPool(LootPool.lootPool()
                        .setRolls(new UniformGenerator(new ConstantValue(1), new ConstantValue(2)))
                        .add(LootItem.lootTableItem(ModItems.GAY_CRYSTALS)))
        );
    }
}
