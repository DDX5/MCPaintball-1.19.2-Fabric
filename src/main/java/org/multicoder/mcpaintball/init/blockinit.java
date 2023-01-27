package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.BlueExplosive;
import org.multicoder.mcpaintball.block.GreenExplosive;
import org.multicoder.mcpaintball.block.RedExplosive;

public class blockinit
{
    public static final Block RED_EXPLOSIVE = RegisterBlock("utility/red_explosive",new RedExplosive());
    public static final Block BLUE_EXPLOSIVE = RegisterBlock("utility/blue_explosive",new BlueExplosive());
    public static final Block GREEN_EXPLOSIVE = RegisterBlock("utility/green_explosive",new GreenExplosive());

    private static Block RegisterBlock(String name, Block block)
    {
        RegisterBlockItem(name,block);
        return Registry.register(Registry.BLOCK,new Identifier(MCPaintball.ModID,name),block);
    }

    private static Item RegisterBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM,new Identifier(MCPaintball.ModID,name),new BlockItem(block,new FabricItemSettings().group(tabinit.paintball)));
    }

    public static void RegsiterBlocks(){

    }
}
