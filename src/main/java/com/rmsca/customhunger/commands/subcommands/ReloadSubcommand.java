package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.CustomHunger;
import com.rmsca.customhunger.commands.Subcommand;
import com.rmsca.customhunger.utils.ChHelper;
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
        plugin.reloadConfig();
        ChHelper.sendMessage(p, "config.yml is reloaded!");
    }
}
