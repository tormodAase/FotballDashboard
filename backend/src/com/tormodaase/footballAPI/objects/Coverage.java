package com.tormodaase.footballAPI.objects;

import com.tormodaase.footballAPI.objects.exceptions.JSONMismatchException;
import com.tormodaase.footballAPI.objects.interfaces.ICoverage;
import org.json.JSONObject;

public class Coverage implements ICoverage {
    private boolean events;
    private boolean lineups;
    private boolean statisticsFixtures;
    private boolean statisticsPlayers;
    private boolean standings;
    private boolean players;
    private boolean topScorers;
    private boolean predictions;
    private boolean odds;
    private JSONObject json;

    public Coverage(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        this.events = json.getJSONObject("fixtures").getBoolean("events");
        this.lineups = json.getJSONObject("fixtures").getBoolean("lineups");
        this.statisticsFixtures = json.getJSONObject("fixtures").getBoolean("statistics_fixtures");
        this.statisticsPlayers = json.getJSONObject("fixtures").getBoolean("statistics_players");
        this.standings = json.getBoolean("standings");
        this.players = json.getBoolean("players");
        this.topScorers = json.getBoolean("top_scorers");
        this.predictions = json.getBoolean("predictions");
        this.odds = json.getBoolean("odds");
        this.json = json;

    }

    @Override
    public boolean getEvents() {
        return events;
    }

    @Override
    public boolean getLineups() {
        return lineups;
    }

    @Override
    public boolean getStatisticsFixtures() {
        return statisticsFixtures;
    }

    @Override
    public boolean getStatisticsPlayers() {
        return statisticsPlayers;
    }

    @Override
    public boolean getStandings() {
        return standings;
    }

    @Override
    public boolean getPlayers() {
        return players;
    }

    @Override
    public boolean getTopScorers() {
        return topScorers;
    }

    @Override
    public boolean getPredictions() {
        return predictions;
    }

    @Override
    public boolean getOdds() {
        return odds;
    }

    @Override
    public String getJSONAsString() {
        return json.toString();
    }

    @Override
    public JSONObject getJSON() {
        return json;
    }

    @Override
    public void validateJSON(JSONObject jsonObject) throws JSONMismatchException {
        //TODO
    }
}
