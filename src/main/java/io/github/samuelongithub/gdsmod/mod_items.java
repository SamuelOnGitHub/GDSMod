package io.github.samuelongithub.gdsmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class mod_items {

    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }
    public static final ConsumableComponent DRUG_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 6 * 20, 1), 1.0f))
            .build();
    public static final FoodComponent Drug_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final RegistryKey<Item> PURPLE_STONE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "purple_stone"));
    public static final Item PURPLE_STONE = register(
            new purple_stone(new Item.Settings().food(Drug_FOOD_COMPONENT, DRUG_CONSUMABLE_COMPONENT).registryKey(PURPLE_STONE_KEY)),
            PURPLE_STONE_KEY
    );
    public static final RegistryKey<Item> REDSTONE_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "redstone_ring"));
    public static final Item REDSTONE_RING = register(
            new redstone_ring(new Item.Settings().maxCount(1).maxDamage(5).registryKey(REDSTONE_RING_KEY)), REDSTONE_RING_KEY
    );
    public static final RegistryKey<Item> D_REDSTONE_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_redstone_ring"));
    public static final Item D_REDSTONE_RING = register(new Item(new Item.Settings().maxCount(1).registryKey(D_REDSTONE_RING_KEY)), D_REDSTONE_RING_KEY);
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(PURPLE_STONE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(REDSTONE_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(D_REDSTONE_RING));
    }
}
