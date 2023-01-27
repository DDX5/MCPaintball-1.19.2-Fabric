package org.multicoder.mcpaintball.item.utility;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.sound.SoundCategory;
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
        NbtCompound Tag = stack.getOrCreateNbt();
        if(user.isSneaking() && Tag.contains("Targets"))
        {
            world.playSound(user,user.getBlockPos(),soundinit.DET, SoundCategory.PLAYERS,0.5f,1f);
            NbtList Targets = Tag.getList("Targets", 8);
            Targets.forEach(
                    tag -> {
                        String[] Pos = tag.asString().split(",");
                        BlockPos Position = new BlockPos(Integer.parseInt(Pos[0]),Integer.parseInt(Pos[1]),Integer.parseInt(Pos[2]));
                        world.createExplosion(null,Position.getX(),Position.getY(),Position.getZ(),5f, Explosion.DestructionType.DESTROY);
                    }
            );
            stack.setNbt(null);
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        ItemStack stack = context.getStack();
        NbtCompound Tag = stack.getOrCreateNbt();
        BlockPos Pos = context.getBlockPos();
        if(!context.getPlayer().isSneaking() && context.getWorld().getBlockState(Pos).getBlock() == blockinit.BLUE_EXPLOSIVE)
        {
            String Position = Pos.getX() + "," + Pos.getY() + "," + Pos.getZ();
            if(Tag.contains("Targets"))
            {
                NbtList Targets = Tag.getList("Targets",8);
                NbtString T = NbtString.of(Position);
                if(Targets.contains(T))
                {
                    context.getWorld().playSound(context.getPlayer(),context.getPlayer().getBlockPos(),soundinit.REM, SoundCategory.PLAYERS,0.5f,1f);
                    Targets.remove(T);
                    Tag.put("Targets",Targets);
                }
                else
                {
                    context.getWorld().playSound(context.getPlayer(),context.getPlayer().getBlockPos(),soundinit.SET,SoundCategory.PLAYERS,0.5f,1f);
                    Targets.add(T);
                    Tag.put("Targets",Targets);
                }
            }
            else
            {
                context.getWorld().playSound(context.getPlayer(),context.getPlayer().getBlockPos(),soundinit.SET,SoundCategory.PLAYERS,0.5f,1f);
                NbtList Targets = new NbtList();
                Targets.add(NbtString.of(Position));
                Tag.put("Targets",Targets);
            }
        }
        stack.setNbt(Tag);
        return super.useOnBlock(context);
    }
}
