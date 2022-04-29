package com.rmsca.customhunger.commands;
import com.rmsca.customhunger.CustomHunger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
public class SetFoodValueCommand implements CommandExecutor {
    // Needs optimization
    Plugin plugin = CustomHunger.getPlugin(CustomHunger.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("customhunger.setfoodvalue")) {
                if(isInteger(args[0])) {
                    int value = Integer.parseInt(args[0]);
                    if(value >= 0 && value <= 20) {
                        p.setFoodLevel(value);
                        return true;
                    } else {
                        p.sendMessage("Invalid argument! Enter a number between 0 and 20!");
                        return false;
                    }
                } else {
                    String targetName = args[0];
                    Player targetPlayer = Bukkit.getServer().getPlayerExact(targetName);
                    if(!(targetPlayer == null)) {
                        if(isInteger(args[1])) {
                            int value = Integer.parseInt(args[1]);
                            if(value >= 0 && value <= 20) {
                                targetPlayer.setFoodLevel(value);
                                return true;
                            } else {
                                p.sendMessage("The second argument should be an integer between 0 and 20!");
                                return false;
                            }
                        } else {
                            p.sendMessage("The second argument should be an integer between 0 and 20!");
                            return false;
                        }
                    } else {
                        p.sendMessage("This player is not online or does not exist! Please check if there is a typo!");
                        return true;
                    }
                }
            } else {
                p.sendMessage("You do not have permission to do this!");
                return true;
            }
        } else {
            if(isInteger(args[0])) {
                plugin.getLogger().info("You must choose a player to set the food value!");
                return false;
            } else {
                String targetName = args[0];
                Player targetPlayer = Bukkit.getServer().getPlayerExact(targetName);
                if(!(targetPlayer == null)) {
                    if(isInteger(args[1])) {
                        int value = Integer.parseInt(args[1]);
                        if(value >= 0 && value <= 20) {
                            targetPlayer.setFoodLevel(value);
                            return true;
                        } else {
                            plugin.getLogger().info("The second argument should be an integer between 0 and 20!");
                            return false;
                        }
                    } else {
                        plugin.getLogger().info("The second argument should be an integer between 0 and 20!");
                        return false;
                    }
                } else {
                    plugin.getLogger().info("This player is not online or does not exist! Please check if there is a typo!");
                    return true;
                }
            }
        }
    }
    private boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
