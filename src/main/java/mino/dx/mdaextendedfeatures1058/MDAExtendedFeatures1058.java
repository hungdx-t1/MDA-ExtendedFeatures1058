package mino.dx.mdaextendedfeatures1058;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MDAExtendedFeatures1058 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            getLogger().severe("BedWars1058 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
