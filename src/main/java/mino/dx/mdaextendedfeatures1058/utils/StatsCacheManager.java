package mino.dx.mdaextendedfeatures1058.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;
import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;

import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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
        cache.put(playerName, stats);
    }

    public PlayerStatsCache getPlayerStats(String playerName) {
        return cache.get(playerName);
    }

    public boolean isCached(String playerName) {
        return cache.containsKey(playerName);
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

    // ?
    public Map<String, String> getPlayerStats(String playerName, boolean isOnline) {
        Map<String, String> stats = new HashMap<>();

        if (isOnline) {
            Player player = Bukkit.getPlayer(playerName);
            stats.put("Kills", PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%"));
            stats.put("Deaths", PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%"));
            stats.put("Wins", PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%"));
            stats.put("Beds Destroyed", PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%"));
            stats.put("Games Played", PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%"));
        } else if (isCached(playerName)) {
            PlayerStatsCache cachedStats = getPlayerStats(playerName);
            stats.put("Kills", String.valueOf(cachedStats.getKills()));
            stats.put("Deaths", String.valueOf(cachedStats.getDeaths()));
            stats.put("Wins", String.valueOf(cachedStats.getWins()));
            stats.put("Beds Destroyed", String.valueOf(cachedStats.getBedsDestroyed()));
            stats.put("Games Played", String.valueOf(cachedStats.getGamesPlayed()));
        }
        // Đảm bảo tất cả các key có giá trị
        stats.putIfAbsent("Kills", "0");
        stats.putIfAbsent("Deaths", "0");
        stats.putIfAbsent("Wins", "0");
        stats.putIfAbsent("Beds Destroyed", "0");
        stats.putIfAbsent("Games Played", "0");
        return stats;
    }
}

