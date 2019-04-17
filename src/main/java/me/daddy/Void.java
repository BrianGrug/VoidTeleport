package me.daddy;

import lombok.Getter;
import me.daddy.listeners.EntityDamageListener;
import me.daddy.listeners.PlayerMoveListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.WeakHashMap;


public class Void extends JavaPlugin {

    @Getter private static Void plugin;
    @Getter public WeakHashMap<UUID, Location> location = new WeakHashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
