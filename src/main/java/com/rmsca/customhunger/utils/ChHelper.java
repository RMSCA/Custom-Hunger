package com.rmsca.customhunger.utils;

public class ChHelper {
    public static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public void sendMessage(Player p, String message) {
        if (p == null) {
            Bukkit.getConsole().sendMessage(message);
        } else {
            p.sendMessage(message);
        }
    }

    public enum DefaultFoodValues {
        APPLE(4),
        BAKED_POTATO(5),
        BEETROOT(1),
        BEETROOT_SOUP(6),
        BREAD(5),
        CARROT(3),
        CHORUS_FRUIT(4),
        COOKED_CHICKEN(6),
        COOKED_COD(5),
        COOKED_MUTTON(6),
        COOKED_PORKCHOP(8),
        COOKED_RABBIT(5),
        COOKED_SALMON(6),
        COOKIE(2),
        DRIED_KELP(1),
        ENCHANTED_GOLDEN_APPLE(4),
        GOLDEN_APPLE(4),
        GLOW_BERRIES(2),
        GOLDEN_CARROT(6),
        HONEY_BOTTLE(6),
        MELON_SLICE(2),
        MUSHROOM_STEW(6),
        POISONOUS_POTATO(2),
        POTATO(1),
        PUFFERFISH(1),
        PUMPKIN_PIE(8),
        RABBIT_STEW(10),
        RAW_BEEF(3),
        RAW_CHICKEN(2),
        RAW_COD(2),
        RAW_MUTTON(2),
        RAW_PORKCHOP(3),
        RAW_RABBIT(3),
        RAW_SALMON(2),
        ROTTEN_FLESH(4),
        SPIDER_EYE(2),
        STEAK(8),
        SUSPICIOUS_STEW(6),
        SWEET_BERRIES(2),
        TROPICAL_FISH(1);
        private final int defaultFoodValue;
        DefaultFoodValues(final int defaultFoodValue) {
            this.defaultFoodValue = defaultFoodValue;
        }
        public int getDefaultFoodValue() {
            return defaultFoodValue;
        }
    }
}
