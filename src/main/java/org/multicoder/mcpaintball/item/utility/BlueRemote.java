package org.multicoder.mcpaintball.item.utility;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.multicoder.mcpaintball.init.blockinit;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;

public class BlueRemote extends Item
{

    public BlueRemote()
    {
        super(new FabricItemSettings().group(tabinit.paintball));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound Tag = stack.getNbt();
        if(Tag == null)
        {
            return TypedActionResult.fail(stack);
        }
        else
        {
            if(Tag.contains("Targets") && user.isSneaking())
            {
                user.playSound(soundinit.DET,0.5f,1.0f);
                String[] Targets = Tag.getString("Targets").split("/");
                for(String Target : Targets)
                {
                    String[] Location = Target.split(",");
                    BlockPos Pos = new BlockPos(Integer.parseInt(Location[0]),Integer.parseInt(Location[1]),Integer.parseInt(Location[2]));
                    world.createExplosion(null,Pos.getX(),Pos.getY(),Pos.getZ(), 5.0f,Explosion.DestructionType.DESTROY);
                }
                stack.setNbt(null);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        ItemStack Stack = context.getStack();
        NbtCompound Tag = Stack.getNbt();
        PlayerEntity user = context.getPlayer();
        BlockPos Pos = context.getBlockPos();
        World world = context.getWorld();
        if(Tag == null)
        {
            Tag = new NbtCompound();
        }
        if(!user.isSneaking() && world.getBlockState(Pos).getBlock() == blockinit.BLUE_EXPLOSIVE)
        {
            user.playSound(soundinit.SET,0.5f,1.0f);
            if(Tag.contains("Targets"))
            {
                String Targets = Tag.getString("Targets");
                Targets += "/" + Pos.getX() + "," + Pos.getY() + "," + Pos.getZ();
                Tag.putString("Targets",Targets);
            }
            else
            {
                String Targets = Pos.getX() + "," + Pos.getY() + "," + Pos.getZ();
                Tag.putString("Targets",Targets);
            }
        }
        Stack.setNbt(Tag);
        return super.useOnBlock(context);
    }
}
