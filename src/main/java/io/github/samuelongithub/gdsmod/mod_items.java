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
    public static final RegistryKey<Item> BLAZE_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "blaze_ring"));
    public static final Item BLAZE_RING = register(
            new blaze_ring(new Item.Settings().maxCount(1).maxDamage(5).registryKey(BLAZE_RING_KEY)), BLAZE_RING_KEY
    );

    public static final RegistryKey<Item> PHANTOM_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "phantom_ring"));
    public static final Item PHANTOM_RING = register( new phantom_ring(new Item.Settings().maxCount(1).maxDamage(20).registryKey(PHANTOM_RING_KEY)), PHANTOM_RING_KEY);

    public static final RegistryKey<Item> D_PHANTOM_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_phantom_ring"));
    public static final Item D_PHANTOM_RING = register( new Item(new Item.Settings().maxCount(1).registryKey(D_PHANTOM_RING_KEY)), D_PHANTOM_RING_KEY);


    public static final RegistryKey<Item> COMBUSTION_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "combustion_ring"));
    public static final Item COMBUSTION_RING = register( new combustion_ring(new Item.Settings().maxCount(1).registryKey(COMBUSTION_RING_KEY)), COMBUSTION_RING_KEY);

    public static final RegistryKey<Item> D_COMBUSTION_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_combustion_ring"));
    public static final Item D_COMBUSTION_RING = register( new Item(new Item.Settings().maxCount(1).registryKey(D_COMBUSTION_RING_KEY)), D_COMBUSTION_RING_KEY);


    public static final RegistryKey<Item> TORCH_PLACER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "torch_placer"));
    public static final Item TORCH_PLACER = register( new torch_placer(new Item.Settings().maxCount(1).maxDamage(108).registryKey(TORCH_PLACER_KEY)), TORCH_PLACER_KEY);

    public static final RegistryKey<Item> D_TORCH_PLACER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_torch_placer"));
    public static final Item D_TORCH_PLACER = register( new Item(new Item.Settings().maxCount(1).registryKey(D_TORCH_PLACER_KEY)), D_TORCH_PLACER_KEY);


    public static final RegistryKey<Item> EMPTY_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "empty_ring"));
    public static final Item EMPTY_RING = register( new Item(new Item.Settings().maxCount(1).maxDamage(5).registryKey(EMPTY_RING_KEY)), EMPTY_RING_KEY);

    public static final RegistryKey<Item> D_REDSTONE_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_redstone_ring"));
    public static final Item D_REDSTONE_RING = register(new Item(new Item.Settings().maxCount(1).registryKey(D_REDSTONE_RING_KEY)), D_REDSTONE_RING_KEY);

    public static final RegistryKey<Item> D_BLAZE_RING_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Gdsmod.MOD_ID, "d_blaze_ring"));
    public static final Item D_BLAZE_RING = register(new Item(new Item.Settings().maxCount(1).registryKey(D_BLAZE_RING_KEY)), D_BLAZE_RING_KEY);
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(PURPLE_STONE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(REDSTONE_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(BLAZE_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(D_REDSTONE_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(D_BLAZE_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(PHANTOM_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(D_PHANTOM_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(COMBUSTION_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(TORCH_PLACER));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(D_COMBUSTION_RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(D_TORCH_PLACER));
    }
}
