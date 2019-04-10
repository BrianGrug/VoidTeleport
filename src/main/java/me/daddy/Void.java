package me.daddy;

import lombok.Getter;
import me.daddy.listeners.PlayerMoveListener;
import org.bukkit.plugin.java.JavaPlugin;


public class Void extends JavaPlugin {

    @Getter private static Void plugin;

    @Override
    public void onEnable() {

        plugin = this;

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
