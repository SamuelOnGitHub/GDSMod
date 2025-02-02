package io.github.samuelongithub.gdsmod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class torch_placer extends Item {
    public torch_placer(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        BlockPos pos = user.getBlockPos();

        if (world.getLightLevel(pos) <= 3) {
            if (user.getInventory().contains(new ItemStack(Items.TORCH))){
                int torchSlotNumber = user.getInventory().getSlotWithStack(new ItemStack(Items.TORCH));
                ItemStack torchStack = user.getInventory().getStack(torchSlotNumber);

                world.setBlockState(pos, Blocks.TORCH.getDefaultState());

                if (!user.isCreative())
                {
                    torchStack.decrement(1);
                    user.getInventory().setStack(torchSlotNumber, torchStack);
                }
            }
        }

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Heal us, Emblem of Dawn!").formatted(Formatting.GOLD));
    }
}