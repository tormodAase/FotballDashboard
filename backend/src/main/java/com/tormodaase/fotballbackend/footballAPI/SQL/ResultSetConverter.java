package main.java.com.tormodaase.fotballbackend.footballAPI.SQL;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Country;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.League;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Season;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Team;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.min.LeagueMinimal;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetConverter {

    public static Team[] getTeams(ResultSet rs) throws SQLException, JSONMismatchException {
        ArrayList<Team> teams = new ArrayList<Team>();
        while (rs.next()) {
            JSONObject teamJson = new JSONObject();
            JSONObject venueJson = new JSONObject();

            teamJson.put("id",          rs.getInt(1));
            teamJson.put("name",        rs.getString(2));
            teamJson.put("country",     rs.getString(3));
            teamJson.put("founded",     rs.getInt(4));
            teamJson.put("national",    rs.getBoolean(5));
            teamJson.put("logo",        rs.getString(6));

            venueJson.put("id",         rs.getInt(7));
            venueJson.put("name",       rs.getString(9));
            venueJson.put("address",    rs.getString(10));
            venueJson.put("city",       rs.getString(11));
            venueJson.put("capacity",   rs.getInt(12));
            venueJson.put("surface",    rs.getString(13));
            venueJson.put("image",      rs.getString(14));

            JSONObject json = new JSONObject();
            json.put("team", teamJson);
            json.put("venue", venueJson);

            Team team = new Team(json);
            teams.add(team);
        }

        Team[] returnValue = new Team[teams.size()];
        return (Team[]) teams.toArray(returnValue);
    }

    public static League[] getLeagues(ResultSet rs) throws SQLException {
        ArrayList<League> leagues = new ArrayList<League>();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            json.put("id", rs.getInt(1));
            json.put("name", rs.getString(2));
            json.put("type", rs.getString(3));
            json.put("logo", rs.getString(4));
            Country country = DatabaseService.selectCountries("where name='"+rs.getString(5)+"'")[0];
            Season[] seasons = DatabaseService.selectSeasons("where leagueId="+((Integer)rs.getInt(1)).toString());

            League league = new League(json, country, seasons);
            leagues.add(league);
        }

        League[] returnValue = new League[leagues.size()];
        return leagues.toArray(returnValue);
    }

    public static LeagueMinimal[] getLeaguesMin(ResultSet rs) throws SQLException {
        ArrayList<LeagueMinimal> leagues = new ArrayList<LeagueMinimal>();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            json.put("id", rs.getInt(1));
            json.put("name", rs.getString(2));
            json.put("type", rs.getString(3));
            json.put("logo", rs.getString(4));

            LeagueMinimal league = new LeagueMinimal(json);
            leagues.add(league);
        }

        LeagueMinimal[] returnValue = new LeagueMinimal[leagues.size()];
        return leagues.toArray(returnValue);
    }

    public static Country[] getCountries(ResultSet rs) throws SQLException, JSONMismatchException {
        ArrayList<Country> countries = new ArrayList<Country>();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            json.put("name", rs.getString(1));
            json.put("code", rs.getString(2));
            json.put("flag", rs.getString(3));
            Country country = new Country(json);
            countries.add(country);
        }

        Country[] returnValue = new Country[countries.size()];
        return countries.toArray(returnValue);
    }

    public static Season[] getSeasons(ResultSet rs) throws SQLException, JSONMismatchException {
        ArrayList<Season> seasons = new ArrayList<Season>();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            json.put("year", rs.getInt(2));
            json.put("start", rs.getString(3));
            json.put("end", rs.getString(4));
            json.put("current", rs.getBoolean(5));
            JSONObject coverageJson = new JSONObject();
            JSONObject fixturesJson = new JSONObject();
            fixturesJson.put("events", rs.getBoolean(6));
            fixturesJson.put("lineups", rs.getBoolean(7));
            fixturesJson.put("statistics_fixtures", rs.getBoolean(8));
            fixturesJson.put("statistics_players", rs.getBoolean(9));
            coverageJson.put("fixtures", fixturesJson);
            coverageJson.put("standings", rs.getBoolean(10));
            coverageJson.put("players", rs.getBoolean(11));
            coverageJson.put("top_scorers", rs.getBoolean(12));
            coverageJson.put("predictions", rs.getBoolean(13));
            coverageJson.put("odds", rs.getBoolean(14));
            json.put("coverage", coverageJson);
            Season season = new Season(json);
            seasons.add(season);
        }

        Season[] returnValue = new Season[seasons.size()];
        return seasons.toArray(returnValue);
    }
}
