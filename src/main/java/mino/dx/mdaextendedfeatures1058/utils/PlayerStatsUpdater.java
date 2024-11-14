package mino.dx.mdaextendedfeatures1058.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;
import org.bukkit.entity.Player;

public class PlayerStatsUpdater {
    private final StatsCacheManager cacheManager;

    public PlayerStatsUpdater(StatsCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void updateStats(Player player) {
        int kills = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%"));
        int deaths = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%"));
        int wins = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%"));
        int bedsDestroyed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%"));
        int gamesPlayed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%"));

        PlayerStatsCache stats = new PlayerStatsCache(player.getName(), kills, deaths, wins, bedsDestroyed, gamesPlayed);
        cacheManager.updateCache(player.getName(), stats);
    }
}
