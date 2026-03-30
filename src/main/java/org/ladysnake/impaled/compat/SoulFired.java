package org.ladysnake.impaled.compat;

import it.crystalnest.soul_fire_d.fire.FireRegistry;
import net.minecraft.entity.Entity;

public final class SoulFired {
    private SoulFired() {}

    public static void setOnSoulFireFor(Entity entity,   int seconds) {
        FireRegistry.register();
    }
}
