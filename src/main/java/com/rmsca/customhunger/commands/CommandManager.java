package com.rmsca.customhunger.commands;

import com.rmsca.customhunger.commands.subcommands.HelpSubcommand;
import com.rmsca.customhunger.commands.subcommands.ReloadSubcommand;
import com.rmsca.customhunger.commands.subcommands.SetFoodLevelSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {
    public static ArrayList<Subcommand> subcommands = new ArrayList<>();

    public CommandManager() {
        subcommands.add(new SetFoodLevelSubcommand());
        subcommands.add(new HelpSubcommand());
        subcommands.add(new ReloadSubcommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = sender instanceof Player ? (Player) sender : null;
        if (args.length > 0) {
            for (Subcommand subcommand : subcommands) {
                if (args[0].equals(subcommand.getName())) {
                    subcommand.execute(p, args);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> tabCompleteSubcommand = new ArrayList<>();
            for (Subcommand subcommand : subcommands) {
                tabCompleteSubcommand.add(subcommand.getName());
            }
            return tabCompleteSubcommand;
        }
        return null;
    }
}
