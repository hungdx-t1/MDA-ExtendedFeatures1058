package mino.dx.mdaextendedfeatures1058.events.player;

import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;
import mino.dx.mdaextendedfeatures1058.utils.StatsCacheManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final StatsCacheManager cacheManager;

    public PlayerJoinListener(StatsCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        int kills = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%"));
        int deaths = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%"));
        int wins = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%"));
        int bedsDestroyed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%"));
        int gamesPlayed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%"));

        PlayerStatsCache stats = new PlayerStatsCache(player.getName(), kills, deaths, wins, bedsDestroyed, gamesPlayed);
        cacheManager.updateCache(player.getName(), stats);
    }
}
