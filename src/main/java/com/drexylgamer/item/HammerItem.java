package com.drexylgamer.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import org.jspecify.annotations.Nullable;

public class HammerItem extends Item {
    public HammerItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemStack stack) {
        // Fetch current damage from the item components safely
        int currentDamage = stack.getOrDefault(DataComponents.DAMAGE, 0);
        int nextDamage = currentDamage + 1;

        // If the hammer's durability limit is reached, return EMPTY (it breaks)
        if (nextDamage >= stack.getMaxDamage()) {
            return ItemStackTemplate.fromStack(ItemStack.EMPTY);
        }

        // Create an updated clone of the stack with the new damage
        ItemStack damagedCopy = stack.copy();
        damagedCopy.set(DataComponents.DAMAGE, nextDamage);

        // Convert the updated ItemStack into the required ItemStackTemplate format
        return ItemStackTemplate.fromStack(damagedCopy);
    }
}