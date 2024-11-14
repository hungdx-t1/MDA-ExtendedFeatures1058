package mino.dx.mdaextendedfeatures1058.features;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.events.interaction.SlashCommandEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DiscordHook {

    private final MDAExtendedFeatures1058 plugin;

    public DiscordHook(MDAExtendedFeatures1058 plugin) {
        this.plugin = plugin;
    }

    public boolean isEnabled(SlashCommandEvent event) {
        boolean enabled = plugin.getConfig().getBoolean("discord-hook", false);
        if(!enabled) {
            event.reply("The Discord stats feature is currently disabled.").queue();
        }
        return enabled;
    }

    public void pingCommand(SlashCommandEvent event) {
        if(isEnabled(event)) {
            event.reply("Pong!").queue();
        }
    }

    public void bestPlugin(SlashCommandEvent event) {
        if(isEnabled(event)) {
            event.reply("DiscordSRV!").queue();
        }
    }

    public void bestFriend(SlashCommandEvent event) {
        if(isEnabled(event)) {
            event.reply("Dogs!").queue();
        }
    }

    public void linkedCommand(SlashCommandEvent event) {
        if(isEnabled(event)) {
            UUID uuid = DiscordSRV.getPlugin().getAccountLinkManager().getUuid(event.getUser().getId());
            if (uuid != null) {
                event.getHook().sendMessage("✅ Your account is linked to " + Bukkit.getOfflinePlayer(uuid).getName() + ".").queue();
            } else {
                event.getHook().sendMessage("❌ Your account is not linked.").queue();
            }
        }
    }

    public void meaningOfLife(SlashCommandEvent event) {
        if(isEnabled(event)) {
            event.getHook().sendMessage("42").queueAfter(5, TimeUnit.SECONDS);
        }
    }

    public void statsExecute(SlashCommandEvent event) {
        if(isEnabled(event)) {
            String playerName = event.getOption("player").getAsString();
            Player player = Bukkit.getPlayer(playerName);

            String kills = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_kills%");
            String deaths = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_deaths%");
            String wins = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_wins%");
            String bedsDestroyed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_bedsdestroyed%");
            String gamesPlayed = PlaceholderAPI.setPlaceholders(player, "%bw1058_stats_gamesplayed%");

            String playerInfo = "**Player Stats for " + playerName + "**\n" +
                    "Kills: " + kills + "\n" +
                    "Deaths: " + deaths + "\n" +
                    "Wins: " + wins + "\n" +
                    "Beds Destroyed: " + bedsDestroyed + "\n" +
                    "Games Played: " + gamesPlayed;
            event.reply(playerInfo).queue();
        }
    }
}
