package mino.dx.mdaextendedfeatures1058.events.server;

import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.models.PlayerStatsCache;
import mino.dx.mdaextendedfeatures1058.utils.StatsCacheManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class GameEndListener implements Listener{
    private final StatsCacheManager cacheManager;

    public GameEndListener(StatsCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        // ?
        for(UUID winner : event.getWinners()) {
            Player player = Bukkit.getPlayer(winner);
            if (player == null) {
                continue;
            }
            if (!player.isOnline()) {
                continue;
            }

            int kills = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%"));
            int deaths = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%"));
            int wins = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%"));
            int bedsDestroyed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%"));
            int gamesPlayed = Integer.parseInt(PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%"));

            PlayerStatsCache stats = new PlayerStatsCache(player.getName(), kills, deaths, wins, bedsDestroyed, gamesPlayed);
            cacheManager.updateCache(player.getName(), stats);
        }
    }
}
