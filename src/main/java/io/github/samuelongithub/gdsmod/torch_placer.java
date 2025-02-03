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

        if (world.getLightLevel(pos) <= 0) {

            if (!world.setBlockState(pos, Blocks.TORCH.getDefaultState())){
                return ActionResult.FAIL;
            }

            ItemStack itemStack = user.getStackInHand(hand);
            if(itemStack.getDamage() < 107 ||  user.isCreative()){
                itemStack.damage(1, user);

            }
            else {
                itemStack.setCount(0);
                user.giveItemStack(new ItemStack(mod_items.D_TORCH_PLACER));
            }
        }

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Heal us, Emblem of Dawn!").formatted(Formatting.GOLD));
    }
}