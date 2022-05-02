package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.CustomHunger;
import com.rmsca.customhunger.commands.CommandHelper;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetFoodValueSubcommand extends Subcommand {

    Plugin plugin = CustomHunger.getPlugin(CustomHunger.class);

    @Override
    protected String getName() {
        return "setfoodlevel";
    }

    @Override
    protected void execute(Player p, String[] args) {
        if (CommandHelper.isInteger(args[1])) {
            p.setFoodLevel(Integer.parseInt(args[1]));
        } else {
            try {
                Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                targetPlayer.setFoodLevel(Integer.parseInt(args[2]));
            } catch (Exception e) {
                p.sendMessage("Could not find this player! Check if there is a typo!");
            }
        }
    }

    @Override
    protected void execute(String[] args) {
        try {
            Player targetPlayer = Bukkit.getPlayerExact(args[1]);
            targetPlayer.setFoodLevel(Integer.parseInt(args[2]));
        } catch (Exception e) {
            if (CommandHelper.isInteger(args[1])) {
                Bukkit.getConsoleSender().sendMessage("You must specify a player name!");
            } else {
                Bukkit.getConsoleSender().sendMessage("Could not find this player! Check if there is a typo!");
            }
        }
    }
}
