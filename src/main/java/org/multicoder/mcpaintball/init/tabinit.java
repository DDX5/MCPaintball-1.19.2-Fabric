package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;
import org.multicoder.mcpaintball.MCPaintball;

public class tabinit
{
    public static final ItemGroup paintball = FabricItemGroupBuilder.build(new Identifier(MCPaintball.ModID,"paintball"), () -> new ItemStack(iteminit.RED_PISTOL));



    public static void RegsiterCreateiveTabs(){

    }
}
