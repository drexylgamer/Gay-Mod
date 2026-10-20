package com.drexylgamer.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final Block BLOCK_OF_GAY = register(
            ModBlockIds.BLOCK_OF_GAY,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(IRON_BLOCK).requiresCorrectToolForDrops().strength(3F)
    );
    public static final Block GAY_ORE = register(
            ModBlockIds.GAY_ORE,
            (p) -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(IRON_ORE).strength(6.5f)
    );
    public static final Block GAY_DEEPSLATE_ORE = register(
            ModBlockIds.GAY_DEEPSLATE_ORE,
            (p) -> new DropExperienceBlock(ConstantInt.of(0), p),
            BlockBehaviour.Properties.ofFullCopy(DEEPSLATE_DIAMOND_ORE).strength(7.5f)
    );

    public static final Block CRYSTALLISER = register(
            ModBlockIds.CRYSTALLISER,
            CrystalliserBlock::new,
                BlockBehaviour.Properties.ofFullCopy(COBBLESTONE).noOcclusion().strength(1F)
    );

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = register(id.block(), blockFactory, properties);

        // Create the block item instance
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {
    }
}
