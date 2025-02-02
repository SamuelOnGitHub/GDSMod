package io.github.samuelongithub.gdsmod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class redstone_ring extends Item {
    public redstone_ring(Settings settings) {
		super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(itemStack.getDamage() < 4 ||  user.isCreative()){
            itemStack.damage(1, user);
        }
        else {
            itemStack.setCount(0);
            user.giveItemStack(new ItemStack(mod_items.D_REDSTONE_RING));
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6*20, 3));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 6*20, 1));
        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Provide for us - Emblem of the Holy War!").formatted(Formatting.GOLD));
    }
}
