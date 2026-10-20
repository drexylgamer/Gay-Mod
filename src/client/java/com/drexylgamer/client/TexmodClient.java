package com.drexylgamer.client;

import com.drexylgamer.block.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class TexmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MenuScreens.register(ModMenuTypes.CRYSTALLISER, CrystallisingScreen::new);
	}
}