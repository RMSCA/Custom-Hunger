package com.rmsca.customhunger.listeners;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
public class PlayerConsumeListener extends JavaPlugin implements Listener {
    private final int BREAD = getConfig().getInt("Bread");
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().getType() == Material.BREAD) {
            System.out.println("Event Triggered!");
            if(p.getFoodLevel() > (20 - BREAD)) {
                p.setFoodLevel(20);
            } else {
                p.setFoodLevel(p.getFoodLevel() + BREAD);
            }
            System.out.println("Process complete!");
        }
    }
}
