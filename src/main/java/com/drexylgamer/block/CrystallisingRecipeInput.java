package com.drexylgamer.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record CrystallisingRecipeInput(ItemStack baseItem, ItemStack bottleItem) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> this.baseItem;
            case 1 -> this.bottleItem;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int size() {
        return 2;
    }


}
