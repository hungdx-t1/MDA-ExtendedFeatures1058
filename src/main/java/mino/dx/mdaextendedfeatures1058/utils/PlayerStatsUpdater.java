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
        String kills = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%");
        String deaths = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%");
        String wins = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%");
        String bedsDestroyed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%");
        String gamesPlayed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%");

        PlayerStatsCache stats = new PlayerStatsCache(player.getName(), kills, deaths, wins, bedsDestroyed, gamesPlayed);
        cacheManager.cachePlayerStats(player.getName(), stats);
    }
}
