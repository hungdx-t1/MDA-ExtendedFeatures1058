package mino.dx.mdaextendedfeatures1058.models;

public class PlayerStatsCache {
    private final String playerName;
    private final String kills;
    private final String deaths;
    private final String wins;
    private final String bedsDestroyed;
    private final String gamesPlayed;

    public PlayerStatsCache(String playerName, String kills, String deaths, String wins,
                            String bedsDestroyed, String gamesPlayed) {
        this.playerName = playerName;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.bedsDestroyed = bedsDestroyed;
        this.gamesPlayed = gamesPlayed;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getKills() {
        return kills;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getWins() {
        return wins;
    }

    public String getBedsDestroyed() {
        return bedsDestroyed;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }
}
