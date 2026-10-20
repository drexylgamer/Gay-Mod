package com.drexylgamer.block;

import com.drexylgamer.Texmod;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockIds {
    public static final BlockItemId BLOCK_OF_GAY = createBlock("block_of_gay");
    public static final BlockItemId GAY_ORE = createBlock("gay_ore");
    public static final BlockItemId GAY_DEEPSLATE_ORE = createBlock("gay_deepslate_ore");
    public static final BlockItemId CRYSTALLISER = createBlock("crystalliser");

    private static BlockItemId createBlock(String name) {
        Identifier id = Texmod.id(name);
        return BlockItemId.create(id, id);
    }
}
