package com.drexylgamer.client;

import com.drexylgamer.block.ModMenuTypes;
import com.drexylgamer.client.entity.GayMiteEntityRenderer;
import com.drexylgamer.client.entity.ModEntityModelLayers;
import com.drexylgamer.entity.ModEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TexmodClient implements ClientModInitializer {
	public static final String ID = "texmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);
	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing Client");

		MenuScreens.register(ModMenuTypes.CRYSTALLISER, CrystallisingScreen::new);
		ModEntityModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntityTypes.GAY_MITE, GayMiteEntityRenderer::new);

		LOGGER.info("Successfully Initialized Client");
	}
}