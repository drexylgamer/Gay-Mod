package com.drexylgamer.block;

import com.drexylgamer.Texmod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {
    public static final MenuType<CrystalliserMenu> CRYSTALLISER = register("crystalliser", CrystalliserMenu::new);

    public static <T extends AbstractContainerMenu> MenuType<T> register(
            String name,
            MenuType.MenuSupplier<T> constructor
    ) {
        return Registry.register(BuiltInRegistries.MENU, Texmod.id(name), new MenuType<>(constructor, FeatureFlagSet.of()));
    }
}