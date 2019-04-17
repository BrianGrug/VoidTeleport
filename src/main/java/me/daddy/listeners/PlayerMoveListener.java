package me.daddy.listeners;

import lombok.Getter;
import me.daddy.Void;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location loc2 = event.getPlayer().getLocation();

        Location loc = loc2.add(0, 1, 0);

        if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            if(event.getFrom().getX() != event.getTo().getX() || event.getFrom().getZ() != event.getTo().getZ()){
                Void.getPlugin().location.put(player.getUniqueId(), loc);
            }
        }
    }
}
