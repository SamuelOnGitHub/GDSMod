package io.github.samuelongithub.gdsmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class purple_stone extends Item {
    public purple_stone(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("and when the men of old mixed lapis into there redstone, they hit the REAL SHIT").formatted(Formatting.GOLD));
    }
}
