package io.github.samuelongithub.gdsmod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

public class phantom_ring extends Item {
    public phantom_ring(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient) {
            return ActionResult.PASS;
        }
        ItemStack itemStack = user.getStackInHand(hand);
        if(itemStack.getDamage() < 4){
            itemStack.damage(1, user);
        }
        else {
            itemStack.setCount(0);
            user.giveItemStack(new ItemStack(mod_items.EMPTY_RING));
        }

        BlockPos pos = user.getBlockPos();

        //Iterate over 3 by 3 grid below player
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                BlockPos gridPosition = pos.offset(Direction.Axis.Y, -1).offset(Direction.Axis.X, i).offset(Direction.Axis.Z, j);

                if (world.getBlockState(gridPosition).equals(Blocks.AIR.getDefaultState())) {
                    world.setBlockState(gridPosition, mod_blocks.PHANTOM_BLOCK.getDefaultState(), 3);
                }
            }
        }

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    BlockPos gridPosition = pos.offset(Direction.Axis.Y, -1).offset(Direction.Axis.X, i).offset(Direction.Axis.Z, j);

                    if (world.getBlockState(gridPosition).equals(mod_blocks.PHANTOM_BLOCK.getDefaultState())) {
                        world.setBlockState(gridPosition, Blocks.AIR.getDefaultState(), 3);
                    }
                }
            }
        }).start();

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("And away you go").formatted(Formatting.GOLD));
    }
}