package mino.dx.mdaextendedfeatures1058.utils;

import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;

import java.util.HashMap;
import java.util.Map;

public class StatsCacheManager {
    private final Map<String, PlayerStatsCache> cache = new HashMap<>();

    public void cachePlayerStats(String playerName, PlayerStatsCache stats) {
        cache.put(playerName.toLowerCase(), stats);
    }

    public PlayerStatsCache getPlayerStats(String playerName) {
        return cache.get(playerName.toLowerCase());
    }

    public boolean isCached(String playerName) {
        return cache.containsKey(playerName.toLowerCase());
    }
}
