package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.CustomHunger;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadSubcommand extends Subcommand {
    Plugin plugin = CustomHunger.getPlugin(CustomHunger.class);
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getUsage() {
        return "Usage: /ch reload";
    }

    @Override
    public void execute(Player p, String[] args) {
        plugin.getLogger().info("Reloading config file!");
        plugin.reloadConfig();
        /* if(isReloaded()) {
            plugin.getLogger().info("Config is reloaded!");
        } else {
            ChHelper.sendMessage(p, "Config has not reloaded!");
        } */
        Integer configValue = plugin.getConfig().getInt(Material.APPLE.toString().toLowerCase());
        plugin.getLogger().info("Getting the value of apple: " + configValue);
    }

    /* private boolean isReloaded() {
        Integer configValue = plugin.getConfig().getInt(Material.APPLE.toString().toLowerCase());
        plugin.getLogger().debug("Getting the value of apple: " + configValue);
        return configValue != 4;
    } */
}
