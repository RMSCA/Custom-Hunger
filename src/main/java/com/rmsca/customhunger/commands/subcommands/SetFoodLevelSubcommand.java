package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.commands.CommandHelper;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetFoodLevelSubcommand extends Subcommand {

    @Override
    protected String getName() {
        return "setfoodlevel";
    }

    @Override
    protected void execute(Player p, String[] args) {
        if (args.length > 1) {
            if (CommandHelper.isInteger(args[1])) {
                p.setFoodLevel(Integer.parseInt(args[1]));
                p.sendMessage("Your food level is now set to " + Integer.parseInt(args[1]));
            } else {
                try {
                    Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                    targetPlayer.setFoodLevel(Integer.parseInt(args[2]));
                    p.sendMessage(targetPlayer.getDisplayName() + "'s food level is now set to " + Integer.parseInt(args[2]));
                } catch (Exception e) {
                    p.sendMessage("Could not find this player! Check if there is a typo!");
                }
            }
        } else {
            p.sendMessage("Please provide an argument!");
        }
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            if (CommandHelper.isInteger(args[1])) {
                Bukkit.getConsoleSender().sendMessage("You must specify a player name!");
            } else {
                try {
                    Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                    targetPlayer.setFoodLevel(Integer.parseInt(args[2]));
                    Bukkit.getConsoleSender().sendMessage(targetPlayer.getDisplayName() + "'s food level is now set to " + Integer.parseInt(args[2]));
                } catch (Exception e) {
                    Bukkit.getConsoleSender().sendMessage("Could not find this player! Check if there is a typo!");
                }
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("Please provide an argument!");
        }
    }
}
