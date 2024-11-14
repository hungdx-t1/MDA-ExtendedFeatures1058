package mino.dx.mdaextendedfeatures1058;

import github.scarsz.discordsrv.api.commands.PluginSlashCommand;
import github.scarsz.discordsrv.api.commands.SlashCommand;
import github.scarsz.discordsrv.api.commands.SlashCommandProvider;
import github.scarsz.discordsrv.dependencies.jda.api.events.interaction.SlashCommandEvent;
import github.scarsz.discordsrv.dependencies.jda.api.interactions.commands.OptionType;
import github.scarsz.discordsrv.dependencies.jda.api.interactions.commands.build.CommandData;
import github.scarsz.discordsrv.dependencies.jda.api.interactions.commands.build.SubcommandData;
import mino.dx.mdaextendedfeatures1058.events.player.PlayerJoinListener;
import mino.dx.mdaextendedfeatures1058.events.server.GameEndListener;
import mino.dx.mdaextendedfeatures1058.features.DiscordHook;
import mino.dx.mdaextendedfeatures1058.utils.StatsCacheManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class MDAExtendedFeatures1058 extends JavaPlugin implements SlashCommandProvider {

    public static MDAExtendedFeatures1058 instance;
    private boolean discordHookEnabled;

    private DiscordHook discordHook;
    private StatsCacheManager cacheManager;

    String pluginName = "MDA-ExtendedFeatures1058";
    String pluginVersion = getDescription().getVersion();
    private static Plugin plugin;

    public static MDAExtendedFeatures1058 getPlugins() {
        return JavaPlugin.getPlugin(MDAExtendedFeatures1058.class);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        cacheManager = new StatsCacheManager(this);
        discordHook = new DiscordHook(this);

        saveDefaultConfig();
        discordHookEnabled = getConfig().getBoolean("discord-hook", true);

        if(discordHookEnabled) {
            if(!Bukkit.getPluginManager().isPluginEnabled("DiscordSRV")) {
                getLogger().severe("DiscordSRV is not installed, disabling...");
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
            getLogger().info("Discord integration is enabled.");
        } else {
            getLogger().info("Discord integration is disabled in config.");
        }

        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            getLogger().severe("BedWars1058 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(cacheManager), this);
        getServer().getPluginManager().registerEvents(new GameEndListener(cacheManager), this);

        getLogger().info("MDA-ExtendedFeatures1058 has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if(cacheManager != null) {
            cacheManager.saveCacheToFile();
        }
        getLogger().info("MDA-ExtendedFeatures1058 has been disabled!");
    }

    // Let DiscordStatsCommand get info config
    public boolean isDiscordHookEnabled() {
        return discordHookEnabled;
    }

    @Override
    public Set<PluginSlashCommand> getSlashCommands() {
        return new HashSet<>(Arrays.asList(
                // ping pong
                new PluginSlashCommand(this, new CommandData("ping", "A classic match of ping pong")),

                // bests
                new PluginSlashCommand(this, new CommandData("best", "Best _____")
                        .addSubcommands(new SubcommandData("friend", "Best friend"))
                        .addSubcommands(new SubcommandData("plugin", "Best plugin"))
                ),

                // linked account
                new PluginSlashCommand(this, new CommandData("linked", "Check the Minecraft account you have linked with your Discord")),

                // most important command
                new PluginSlashCommand(this, new CommandData("life", "What is the meaning of life?")),

                new PluginSlashCommand(this, new CommandData("bedwars", "Return stats of player in Bedwars server")
                        .addOption(OptionType.STRING,"player","Player name",true))
        ));
    }

    @SlashCommand(path = "ping")
    public void pingCommand(SlashCommandEvent event) {
       discordHook.pingCommand(event);
    }

    @SlashCommand(path = "best/plugin")
    public void bestPlugin(SlashCommandEvent event) {
       discordHook.bestPlugin(event);
    }

    @SlashCommand(path = "best/friend")
    public void bestFriend(SlashCommandEvent event) {
        discordHook.bestFriend(event);
    }

    @SlashCommand(path = "linked", deferReply = true, deferEphemeral = true)
    public void linkedCommand(SlashCommandEvent event) {
        discordHook.linkedCommand(event);
    }

    @SlashCommand(path = "life", deferReply = true)
    public void meaningOfLife(SlashCommandEvent event) {
        discordHook.meaningOfLife(event);
    }

    @SlashCommand(path = "bedwars")
    public void statsExecute(SlashCommandEvent event) {
        discordHook.statsExecute(event);
    }

    public StatsCacheManager getCacheManager() {
        return cacheManager;
    }
}
