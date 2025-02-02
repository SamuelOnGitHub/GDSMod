package io.github.samuelongithub.gdsmod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Vector;

public class combustion_ring extends Item {
    public combustion_ring(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if( !user.isCreative()){
            itemStack.setCount(0);
            user.giveItemStack(new ItemStack(mod_items.D_COMBUSTION_RING));
        }

        BlockPos blockPos = user.getBlockPos();
        Direction direction = user.getFacing();
        blockPos = blockPos.offset(direction, 2);

        TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
        tntEntity.setPosition(blockPos.toCenterPos());

        tntEntity.setFuse(0);
        tntEntity.setNoGravity(true);
        tntEntity.setInvisible(true);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 10));
        world.spawnEntity(tntEntity);

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("and thus your foes went KABOOM!").formatted(Formatting.GOLD));
    }
}