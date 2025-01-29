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

public class blaze_ring extends Item {
    public blaze_ring(Settings settings) {
		super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.isFireImmune()){
            user.sendMessage(Text.of("those who fear not the flames cannot feel it's burn"), false);
            return super.use(world, user, hand);
        }
        if(itemStack.getDamage() < 4){
            itemStack.damage(1, user);
        }
        else {
            itemStack.setCount(0);
            user.giveItemStack(new ItemStack(mod_items.D_BLAZE_RING));
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6*20, 3));
        user.setFireTicks(6*20);
        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("and then they burnt to ash before they knew the power of this aroma").formatted(Formatting.GOLD));
    }
}
