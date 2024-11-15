package mino.dx.mdaextendedfeatures1058.languages;

import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LanguageManager {
    private final MDAExtendedFeatures1058 plugin;
    private FileConfiguration langConfig;
    private final Map<String, FileConfiguration> languages = new HashMap<>();

    public LanguageManager(MDAExtendedFeatures1058 plugin) {
        this.plugin = plugin;
        loadLanguageFiles();
    }

    public void loadLanguageFiles() {
        String selectedLang = plugin.getConfig().getString("locale", "vi");
        File langFile = new File(plugin.getDataFolder(), "lang_" + selectedLang + ".yml");

        if(!langFile.exists()) {
            plugin.saveResource("lang_" + selectedLang + ".yml", false);
        }

        langConfig = YamlConfiguration.loadConfiguration(langFile);
        loadDefaultLanguageFiles();
    }

    public void loadDefaultLanguageFiles() {
        for(String lang : new String[]{"en", "vi"}) {
            File file = new File(plugin.getDataFolder(), "lang_" + lang + ".yml");
            if(!file.exists()) {
                plugin.saveResource("lang_" + lang + ".yml", false);
            }
            languages.put(lang, YamlConfiguration.loadConfiguration(file));
        }
    }

    public String getMessage(String path) {
        return langConfig.getString(path, "Message not found: " + path);
    }

    public String getMessage(String path, String defaultVal) {
        return langConfig.getString(path, defaultVal);
    }
}
