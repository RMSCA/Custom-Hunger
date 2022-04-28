package com.rmsca.customhunger;
import com.rmsca.customhunger.listeners.PlayerConsumeListener;
import org.bukkit.plugin.java.JavaPlugin;
public final class CustomHunger extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Custom-Hunger is enabled!");
        // Register events
        getServer().getPluginManager().registerEvents(new PlayerConsumeListener(), this);
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Custom-Hunger is disabled!");
    }
}
