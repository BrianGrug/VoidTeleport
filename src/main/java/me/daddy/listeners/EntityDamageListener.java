package me.daddy.listeners;

import me.daddy.Void;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.potion.PotionEffectType.CONFUSION;
import static org.bukkit.potion.PotionEffectType.DAMAGE_RESISTANCE;

public class EntityDamageListener implements Listener {


    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();

            if(event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.setCancelled(true);
                player.teleport(Void.getPlugin().location.get(player.getUniqueId()));

                if (Void.getPlugin().getConfig().getBoolean("Effects")) {
                    player.addPotionEffect(new PotionEffect(CONFUSION, 200, 2));
                }
            }
        }
    }
}
