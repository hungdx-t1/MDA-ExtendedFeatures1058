package mino.dx.mdaextendedfeatures1058.models;

public class PlayerStatsCache {
    private final String playerName;
    private final int kills;
    private final int deaths;
    private final int wins;
    private final int bedsDestroyed;
    private final int gamesPlayed;

    public PlayerStatsCache(String playerName, int kills, int deaths, int wins,
                            int bedsDestroyed, int gamesPlayed) {
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

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getWins() {
        return wins;
    }

    public int getBedsDestroyed() {
        return bedsDestroyed;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}
