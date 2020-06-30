package org.livermorevalleyacademy.CustomWeapon.events;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setDamage(20 * event.getDamage());
        Entity entity = event.getEntity();
        World world = entity.getWorld();
        Location entityLoc = entity.getLocation();
        world.spawnParticle(Particle.LAVA, entityLoc, 3);
        world.spawnParticle(Particle.FLAME, entityLoc, 1);
        world.playSound(entityLoc, Sound.ENTITY_GENERIC_BURN, 0.5f, 0.6f);
    }
}
