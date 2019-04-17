package me.daddy.voidteleport;

import me.daddy.voidteleport.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Void extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }
}
