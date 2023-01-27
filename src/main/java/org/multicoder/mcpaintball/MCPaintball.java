package org.multicoder.mcpaintball;

import net.fabricmc.api.ModInitializer;
import org.multicoder.mcpaintball.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCPaintball implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("mcpaintball");
	public static final String ModID = "mcpaintball";

	@Override
	public void onInitialize()
	{
		iteminit.RegisterItems();
		soundinit.RegisterSounds();
		entityinit.RegsiterEnity();
		blockinit.RegsiterBlocks();
		tabinit.RegsiterCreateiveTabs();
	}
}
