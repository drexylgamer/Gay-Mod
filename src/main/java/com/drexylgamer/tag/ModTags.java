package com.drexylgamer.tag;

import com.drexylgamer.Texmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static TagKey<Item> REPAIRS_GAY_ARMOR;
    public static TagKey<Item> GAY_TOOL_MATERIALS;

    public static TagKey<Block> INCORRECT_FOR_GAY_TOOL;
    public static TagKey<Block> NEEDS_GAY_TOOL;

    public ModTags() {
    }
    static {
        REPAIRS_GAY_ARMOR = bind("repairs_gay_armor");
        GAY_TOOL_MATERIALS = bind("gay_tool_materials");

        INCORRECT_FOR_GAY_TOOL = create("incorrect_for_gay_tool");
        NEEDS_GAY_TOOL = create("needs_gay_tool");
    }

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, Texmod.id(name));
    }

    private static TagKey<net.minecraft.world.level.block.Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(name));
    }
}
