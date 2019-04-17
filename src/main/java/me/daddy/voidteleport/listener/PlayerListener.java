package me.daddy.voidteleport.listener;

import lombok.RequiredArgsConstructor;
import me.daddy.voidteleport.Void;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.WeakHashMap;

@RequiredArgsConstructor
public class PlayerListener implements Listener {
    private final Void plugin;

    // Remove their Location entry whenever the Player object is null.
    private final Map<Player, Location> locationMap = new WeakHashMap<>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();

        if (location.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
            locationMap.put(player, location);

        FileConfiguration config = plugin.getConfig();

        if (location.getBlockY() < config.getInt("Level")) {
            player.teleport(locationMap.get(player));

            if (config.getBoolean("Effects"))
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 2));
        }
    }
}
