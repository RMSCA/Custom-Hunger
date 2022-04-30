package com.rmsca.customhunger.commands;

import com.rmsca.customhunger.commands.subcommands.SetFoodValueSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {
    ArrayList<Subcommand> subcommands = new ArrayList<>();

    public CommandManager() {
        subcommands.add(new SetFoodValueSubcommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                for (int i = 0; i < subcommands.size(); i++) {
                    if (args[0].equals(subcommands.get(i).getName())) {
                        subcommands.get(i).execute(p, args);
                    }
                }
            }
        }
        return true;
    }
}
