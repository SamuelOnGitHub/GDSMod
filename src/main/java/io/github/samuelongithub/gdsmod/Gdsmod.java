package io.github.samuelongithub.gdsmod;

import net.fabricmc.api.ModInitializer;

public class Gdsmod implements ModInitializer {
    public static final String MOD_ID = "gdsmod";
    @Override
    public void onInitialize() {
        mod_items.initialize();
        mod_blocks.initialize();
    }
}
