package mino.dx.mdaextendedfeatures1058.utils;

import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;
import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;

import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class StatsCacheManager {
    private final Map<String, PlayerStatsCache> cache = new HashMap<>();
    private final File cacheFile;
    private final FileConfiguration cacheConfig;

    public StatsCacheManager(MDAExtendedFeatures1058 plugin) {
        this.cacheFile = new File(plugin.getDataFolder(),"player_cache.yml");
        this.cacheConfig = YamlConfiguration.loadConfiguration(cacheFile);
        loadCacheFromFile();
    }

    public void updateCache(String playerName, PlayerStatsCache stats) {
        cache.put(playerName.toLowerCase(), stats);
    }

    public PlayerStatsCache getPlayerStats(String playerName) {
        return cache.get(playerName.toLowerCase());
    }

    public boolean isCached(String playerName) {
        return cache.containsKey(playerName.toLowerCase());
    }

    public void saveCacheToFile() {
        for (String playerName : cache.keySet()) {
            PlayerStatsCache stats = cache.get(playerName);

            cacheConfig.set(playerName + ".kills", stats.getKills());
            cacheConfig.set(playerName + ".deaths", stats.getDeaths());
            cacheConfig.set(playerName + ".wins", stats.getWins());
            cacheConfig.set(playerName + ".bedsDestroyed", stats.getBedsDestroyed());
            cacheConfig.set(playerName + ".gamesPlayed", stats.getGamesPlayed());
        }
        try {
            cacheConfig.save(cacheFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCacheFromFile() {
        if(!cacheFile.exists()) return;
        for(String playerName : cacheConfig.getKeys(false)) {
            int kills = cacheConfig.getInt(playerName + ".kills");
            int deaths = cacheConfig.getInt(playerName + ".deaths");
            int wins = cacheConfig.getInt(playerName + ".wins");
            int bedsDestroyed = cacheConfig.getInt(playerName + ".bedsDestroyed");
            int gamesPlayed = cacheConfig.getInt(playerName + ".gamesPlayed");

            PlayerStatsCache stats = new PlayerStatsCache(playerName, kills, deaths, wins, bedsDestroyed, gamesPlayed);
            cache.put(playerName, stats);
        }
    }
}

