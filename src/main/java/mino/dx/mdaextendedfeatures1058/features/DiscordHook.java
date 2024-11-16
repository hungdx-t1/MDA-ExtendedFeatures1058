package mino.dx.mdaextendedfeatures1058.features;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.EmbedBuilder;
import github.scarsz.discordsrv.dependencies.jda.api.events.interaction.SlashCommandEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;
import mino.dx.mdaextendedfeatures1058.utils.*;
import mino.dx.mdaextendedfeatures1058.languages.*;
import mino.dx.mdaextendedfeatures1058.models.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DiscordHook {

    private final MDAExtendedFeatures1058 plugin;
    private final StatsCacheManager cacheManager;

    public DiscordHook(MDAExtendedFeatures1058 plugin) {
        this.plugin = plugin;
        this.cacheManager = plugin.getCacheManager();

        if(this.cacheManager == null) {
            plugin.getLogger().warning("CacheManager is null in DiscordHook. Make sure " +
                    "it is initialized correctly.");
        }
    }

    public void pingCommand(SlashCommandEvent event) {
        event.reply("Pong!").queue();
    }

    public void bestPlugin(SlashCommandEvent event) {
        event.reply("DiscordSRV!").queue();
    }

    public void bestFriend(SlashCommandEvent event) {
        event.reply("Dogs!").queue();
    }

    public void linkedCommand(SlashCommandEvent event) {
        UUID uuid = DiscordSRV.getPlugin().getAccountLinkManager().getUuid(event.getUser().getId());
        if (uuid != null) {
            event.getHook().sendMessage("✅ Your account is linked to " + Bukkit.getOfflinePlayer(uuid).getName() + ".").queue();
        } else {
            event.getHook().sendMessage("❌ Your account is not linked.").queue();
        }
    }

    public void meaningOfLife(SlashCommandEvent event) {
        event.getHook().sendMessage("42").queueAfter(5, TimeUnit.SECONDS);
    }

    public void statsExecute(SlashCommandEvent event) {
        String playerName = event.getOption("player").getAsString();
        Player player = Bukkit.getPlayer(playerName);

        if(player != null && player.isOnline()) {
            new PlayerStatsUpdater(cacheManager).updateStats(player);

            String kills = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%");
            String deaths = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%");
            String wins = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%");
            String bedsDestroyed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%");
            String gamesPlayed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%");

            EmbedBuilder embed = buildEmbedForPlayer(playerName, kills, deaths, wins, bedsDestroyed, gamesPlayed);
            // event.reply(playerInfo).queue();
            event.replyEmbeds(embed.build()).queue();

        } else if (cacheManager != null && cacheManager.isCached(playerName)) {
            PlayerStatsCache stats = cacheManager.getPlayerStats(playerName);

            String playerName_rep = stats.getPlayerName();
            String kills = String.valueOf(stats.getKills());
            String deaths = String.valueOf(stats.getDeaths());
            String wins = String.valueOf(stats.getWins());
            String bedsDestroyed = String.valueOf(stats.getBedsDestroyed());
            String gamesPlayed = String.valueOf(stats.getGamesPlayed());

            EmbedBuilder embed = buildEmbedForPlayer(playerName_rep, kills, deaths, wins, bedsDestroyed, gamesPlayed);
            // event.reply(playerInfo).queue();
            event.replyEmbeds(embed.build()).queue();

        } else {
            event.reply("No stats found for player: " + playerName).queue();
        }
    }

    private EmbedBuilder buildEmbedForPlayer(String playerName, String kills, String deaths, String wins,
                                             String bedsDestroyed, String gamesPlayed) {
        EmbedBuilder embed = new EmbedBuilder();

        int ckills = Integer.parseInt(kills);
        int cdeaths = Integer.parseInt(deaths);
        int cwins = Integer.parseInt(wins);
        int cbedsDestroyed = Integer.parseInt(bedsDestroyed);
        int cgamesPlayed = Integer.parseInt(gamesPlayed);

        embed.setAuthor(Messages.getAuthorName(), Messages.getAuthorUrl(), Messages.getAuthorIconUrl());
        embed.setTitle(Messages.getTitle().replace("%player_name%", playerName));
        embed.setDescription(Messages.getDescription(ckills, cdeaths, cwins, cbedsDestroyed, cgamesPlayed));
        
        embed.setColor(Color.decode(Messages.getHexColor()));

        String footer = Messages.getFooter();
        if (footer != null && !footer.isEmpty()) {
            embed.setFooter(footer);
        }
        embed.setTimestamp(Instant.now());
        return embed;
    }
}
