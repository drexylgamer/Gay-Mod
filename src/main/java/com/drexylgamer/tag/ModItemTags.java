package com.drexylgamer.tag;

import com.drexylgamer.Texmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static TagKey<Item> REPAIRS_GAY_ARMOR;

    public ModItemTags() {
    }
    static {
        REPAIRS_GAY_ARMOR = bind("repairs_gay_armor");
    }

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, Texmod.id(name));
    }
}
