package com.rmsca.customhunger.listeners;

import com.rmsca.customhunger.CustomHunger;
import com.rmsca.customhunger.utils.ChHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class PlayerConsumeListener implements Listener {
    Plugin plugin = CustomHunger.getPlugin(CustomHunger.class);
    private static Map<Material, Integer> foodValueMap;

    private Integer getConfiguredFoodValue(Material material) {
        Integer foodValue = null;
        if (foodValueMap == null) {
            foodValueMap = getFoodValueMap();
        }
        if (foodValueMap.containsKey(material)) {
            foodValue = foodValueMap.get(material);
        }
        return foodValue;
    }

    private HashMap<Material, Integer> getFoodValueMap() {
        Map<Material, Integer> foodValueMap = new HashMap<>();
        for (Material m : Material.values()) {
            if (m.isEdible()) {
                Integer configValue = plugin.getConfig().getInt(m.toString().toLowerCase());
                foodValueMap.put(m, configValue);
            }
        }
        return foodValueMap;
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        Integer configuredFoodLevel = getConfiguredFoodValue(e.getItem().getType());
        Integer defaultFoodValue = null;
        Material m = e.getItem().getType();
        for (ChHelper.DefaultFoodValues d : ChHelper.DefaultFoodValues.values()) {
            if (m.toString().equalsIgnoreCase(d.toString())) {
                defaultFoodValue = d.getDefaultFoodValue();
                break;
            }
        }
        if (defaultFoodValue == null) {
            plugin.getLogger().severe("Encountered error when trying to get the default food value! The event is cancelled!");
            p.sendMessage("Encountered unknown error! Please report this to an admin! (Default food value)");
            e.setCancelled(true);
            return;
        }
        if (configuredFoodLevel != null) {
            if (p.getFoodLevel() > (20 - configuredFoodLevel)) {
                p.setFoodLevel(20);
            } else {
                p.setFoodLevel(p.getFoodLevel() + configuredFoodLevel - defaultFoodValue);
            }
        } else {
            plugin.getLogger().severe("PlayerConsumeListener#getConfiguredFoodValue() returned null!");
            p.sendMessage("Encountered unknown error! Please report this to an admin! (getConfiguredFoodValue)");
        }
    }
}
