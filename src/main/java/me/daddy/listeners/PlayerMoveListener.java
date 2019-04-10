package me.daddy.listeners;

import me.daddy.Void;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.potion.PotionEffectType.CONFUSION;

public class PlayerMoveListener implements Listener {

    private HashMap<UUID, Location> location = new HashMap<>();


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location loc = event.getPlayer().getLocation();

        if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            location.put(player.getUniqueId(), loc);
        }

        if(player.getLocation().getBlockY() < 0){
            player.teleport(location.get(player.getUniqueId()));

            if(Void.getPlugin().getConfig().getBoolean("Effects")){
                player.addPotionEffect(new PotionEffect(CONFUSION, 200, 2));
            }
        }
    }
}
