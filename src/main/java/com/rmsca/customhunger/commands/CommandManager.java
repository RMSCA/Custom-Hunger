package com.rmsca.customhunger.commands;

import com.rmsca.customhunger.commands.subcommands.SetFoodLevelSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {
    ArrayList<Subcommand> subcommands = new ArrayList<>();

    public CommandManager() {
        subcommands.add(new SetFoodLevelSubcommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                for (Subcommand subcommand : subcommands) {
                    if (args[0].equals(subcommand.getName())) {
                        subcommand.execute(p, args);
                        return true;
                    }
                }
            }
        } else {
            if (args.length > 0) {
                for (Subcommand subcommand : subcommands) {
                    if (args[0].equals(subcommand.getName())) {
                        subcommand.execute(args);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
