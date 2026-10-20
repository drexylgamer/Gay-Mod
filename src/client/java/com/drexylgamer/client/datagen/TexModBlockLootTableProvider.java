package com.drexylgamer.client.datagen;

import com.drexylgamer.block.ModBlocks;
import com.drexylgamer.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class TexModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public TexModBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.BLOCK_OF_GAY);
        dropWhenSilkTouch(ModBlocks.GAY_ORE);
        dropWhenSilkTouch(ModBlocks.GAY_DEEPSLATE_ORE);
        add(ModBlocks.GAY_ORE, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(new UniformGenerator(new ConstantValue(1), new ConstantValue(3)))
                .add(LootItem.lootTableItem(ModItems.RAW_GAY))));
        add(ModBlocks.GAY_DEEPSLATE_ORE, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(new UniformGenerator(new ConstantValue(2), new ConstantValue(4)))
                .add(LootItem.lootTableItem(ModItems.RAW_GAY))));
    }
}

