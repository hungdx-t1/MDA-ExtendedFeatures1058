package mino.dx.mdaextendedfeatures1058.languages;

import mino.dx.mdaextendedfeatures1058.MDAExtendedFeatures1058;

public class Messages {

    private static MDAExtendedFeatures1058 plugin;

    public static void initialize(MDAExtendedFeatures1058 pluginInstance) {
        plugin = pluginInstance;
    }

    //
    // *** Embed header ***
    //

    public static String getAuthorName() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-author.author", "@MinoMC_YTB");
    }

    public static String getAuthorUrl() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-author.author-url", "");
    }

    public static String getAuthorIconUrl() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-author.author-icon-url", "");
    }

    public static String getTitle() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.title", "%player_name%'s Stats");
    }

//    public static String getDescription() {
//        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.description", "Số liệu của người chơi này được hiện:");
//    }

    public static String getDescription(int a, int b, int c, int d, int e) {
        String killsText =
                plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.kills-text", "**Kills:**");
        String deathsText =
                plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.deaths-text", "**Deaths:**");
        String winsText =
                plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.wins-text", "**Wins:**");;
        String bedsDestroyedText =
                plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.bedsDestroyed-text", "**Beds Destroyed:**");;
        String gamesPlayedText =
                plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.gamesPlayed-text", "**Games Played:**");;

        String mode = "0";
        String description, prefix;

        switch(mode) {
            case "0":
                prefix = "bw1058_stats";
                break;
            case "1":
                prefix = "groupstats_solo";
                break;
            case "2":
                prefix = "groupstats_doubles";
                break;
            case "3":
                prefix = "groupstats_3v3v3v3";
                break;
            case "4":
                prefix = "groupstats_4v4v4v4";
                break;
            default:
                prefix = null;
                break;
        }
        description = plugin.getLanguageManager().getMessage("discord-hook.embed-body.description", "Số liệu của người chơi này được hiện:")
                .replace("%mda_kills_text%", killsText)
                .replace("%mda_deaths_text%", deathsText)
                .replace("%mda_wins_text%", winsText)
                .replace("%mda_bedsDestroyed_text%", bedsDestroyedText)
                .replace("%mda_gamesPlayed_text%", gamesPlayedText)
                .replace("%"+ prefix + "_kills%", String.valueOf(a))
                .replace("%"+ prefix + "_deaths%", String.valueOf(b))
                .replace("%"+ prefix + "_wins%", String.valueOf(c))
                .replace("%"+ prefix + "_bedsdestroyed%", String.valueOf(d))
                .replace("%"+ prefix + "_gamesplayed%", String.valueOf(e));
        return description;
    }

    public static String getHexColor() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.hex-color", "#58b9ff");
    }

    //
    // *** Text ***
    //

    public static String getKillsText() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.kills-text", "**Số lần chết:**");
    }

    public static String getDeathsText() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.deaths-text", "**Số lần chết:**");
    }

    public static String getWinsText() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.wins-text", "**Số lần thắng:**");
    }

    public static String getBedsDestroyedText() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.bedsDestroyed-text", "**Số lần phá giường:**");
    }

    public static String getGamesPlayedText() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-body.text.gamesPlayed-text", "**Tổng số trận chơi:**");
    }

    //
    // *** Get All mode stats ***
    //

    public static String getKillsValue(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.all-stats.kills-value", "").replace("%bw1058_stats_kills%", String.valueOf(variable));
    }

    public static String getDeathsValue(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.all-stats.deaths-value", "").replace("%bw1058_stats_deaths%", String.valueOf(variable));
    }

    public static String getWinsValue(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.all-stats.wins-value", "").replace("%bw1058_stats_wins%", String.valueOf(variable));
    }

    public static String getBedsDestroyedValue(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.all-stats.bedsDestroyed-value", "").replace("%bw1058_stats_bedsdestroyed%", String.valueOf(variable));
    }

    public static String getGamesPlayedValue(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.all-stats.gamesPlayed-value", "").replace("%bw1058_stats_gamesplayed%", String.valueOf(variable));
    }

    //
    // *** Get solo stats ***
    //

    public static String getKillsValue_solo(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.solo.kills-value", "").replace("%groupstats_solo_kills%", String.valueOf(variable));
    }

    public static String getDeathsValue_solo(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.solo.deaths-value", "").replace("%groupstats_solo_deaths%", String.valueOf(variable));
    }

    public static String getWinsValue_solo(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.solo.wins-value", "").replace("%groupstats_solo_wins%", String.valueOf(variable));
    }

    public static String getBedsDestroyedValue_solo(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.solo.bedsDestroyed-value", "").replace("%groupstats_solo_bedsBroken%", String.valueOf(variable));
    }

    public static String getGamesPlayedValue_solo(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.solo.gamesPlayed-value", "").replace("%groupstats_solo_gamesPlayed%", String.valueOf(variable));
    }

    //
    // *** Get doubles stats ***
    //

    public static String getKillsValue_doubles(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.doubles.kills-value", "").replace("%groupstats_doubles_kills%", String.valueOf(variable));
    }

    public static String getDeathsValue_doubles(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.doubles.deaths-value", "").replace("%groupstats_doubles_deaths%", String.valueOf(variable));
    }

    public static String getWinsValue_doubles(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.doubles.wins-value", "").replace("%groupstats_doubles_wins%", String.valueOf(variable));
    }

    public static String getBedsDestroyedValue_doubles(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.doubles.bedsDestroyed-value", "").replace("%groupstats_doubles_bedsBroken%", String.valueOf(variable));
    }

    public static String getGamesPlayedValue_doubles(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.doubles.gamesPlayed-value", "").replace("%groupstats_doubles_gamesPlayed%", String.valueOf(variable));
    }

    //
    // *** Get 3v3v3v3 stats ***
    //

    public static String getKillsValue_3v3v3v3(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.3v3v3v3.kills-value", "").replace("%groupstats_3v3v3v3_kills%", String.valueOf(variable));
    }

    public static String getDeathsValue_3v3v3v3(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.3v3v3v3.deaths-value", "").replace("%groupstats_3v3v3v3_deaths%", String.valueOf(variable));
    }

    public static String getWinsValue_3v3v3v3(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.3v3v3v3.wins-value", "").replace("%groupstats_3v3v3v3_wins%", String.valueOf(variable));
    }

    public static String getBedsDestroyedValue_3v3v3v3(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.3v3v3v3.bedsDestroyed-value", "").replace("%groupstats_3v3v3v3_bedsBroken%", String.valueOf(variable));
    }

    public static String getGamesPlayedValue_3v3v3v3(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.3v3v3v3.gamesPlayed-value", "").replace("%groupstats_3v3v3v3_gamesPlayed%", String.valueOf(variable));
    }
    //
    // *** Get 4v4v4v4 stats ***
    //

    public static String getKillsValue_4v4v4v4(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.4v4v4v4.kills-value", "").replace("%groupstats_4v4v4v4_kills%", String.valueOf(variable));
    }

    public static String getDeathsValue_4v4v4v4(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.4v4v4v4.deaths-value", "").replace("%groupstats_4v4v4v4_deaths%", String.valueOf(variable));
    }

    public static String getWinsValue_4v4v4v4(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.4v4v4v4.wins-value", "").replace("%groupstats_4v4v4v4_wins%", String.valueOf(variable));
    }

    public static String getBedsDestroyedValue_4v4v4v4(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.4v4v4v4.bedsDestroyed-value", "").replace("%groupstats_4v4v4v4_bedsBroken%", String.valueOf(variable));
    }

    public static String getGamesPlayedValue_4v4v4v4(int variable) {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-fields.4v4v4v4.gamesPlayed-value", "").replace("%groupstats_4v4v4v4_gamesPlayed%", String.valueOf(variable));
    }

    //
    // *** Images ***
    //

    public static String getImageURLs() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-images.image-urls", "@MinoMC_YTB");
    }

    public static String getThumbnailURL() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-images.thumbnail-url", "@MinoMC_YTB");
    }

    //
    // *** Embed Footer ***
    //

    public static String getFooter() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-footer.footer", "@MinoMC_YTB");
    }

    public static String getFooterIconUrl() {
        return plugin.getLanguageManager().getMessage("discord-hook.embed-footer.footer-icon-url", "@MinoMC_YTB");
    }
}