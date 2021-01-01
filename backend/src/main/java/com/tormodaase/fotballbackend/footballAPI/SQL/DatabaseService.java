package main.java.com.tormodaase.fotballbackend.footballAPI.SQL;

import main.java.com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.*;

import java.sql.*;
import java.util.prefs.Preferences;

public class DatabaseService {
    private static Connection connection;
    public static void connect() throws SQLException, EnvironmentVariableException {
        Preferences prefs = Preferences.systemRoot().node("com/tormodaase/fotballbackend");
        String connectionString = prefs.get("sql_connection_string", null);
        String username = prefs.get("sql_username", null);
        String password = prefs.get("sql_password", null);
        if (connectionString == null || username == null || password == null) {
            String errorMessage = "Variable(s) not found. Please run SetEnvironmentVariables. ";
            errorMessage += "Connection String: "   + (connectionString == null ? "NULL" : "DEFINED");
            errorMessage += ", Username: "          + (username == null ? "NULL" : "DEFINED");
            errorMessage += ", Password: "          + (password == null ? "NULL" : "DEFINED");
            throw new EnvironmentVariableException(errorMessage);
        }
        connection = DriverManager.getConnection(connectionString, username, password);
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public static void upsertItem(Object object) throws SQLException {
        if (object.getClass().equals(Country.class)) {
            upsertCountry((Country) object);
        }
        //TODO create more cases
    }

    public static void upsertCountry(Country country) throws SQLException {
        String[] values = {country.getName(), country.getCode(), country.getFlag()};
        String query = "INSERT into dbo.countries(name, code, flag)"
                +       "VALUES('"
                +       String.join("','", values)
                +"')";

        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(query);
        }
    }

    public static void upsertLeague(League league) throws SQLException {
        Object[] values = {league.getID(), league.getName(), league.getType(), league.getLogo(), league.getCountry().getName()};

        String query = "INSERT into dbo.leagues(id, name, type, logo, country)"
                     +  values(values);

        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(query);
        }

        Season[] seasons = league.getSeasons();
        for (int i=0; i<seasons.length; i++) {
            upsertSeason(seasons[i], league.getID());
        }
    }

    public static void upsertTeam(Team team) {
        Object[] values = {
                team.getID(),
                team.getName(),
                team.getCountry(),
                team.getFounded(),
                team.getNational(),
                team.getLogo(),
                team.getVenue().getID()
        };

        String query = "INSERT into dbo.teams(id, name, country, founded, [national], logo, venueId)"
                     +  values(values);

        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(query);
        }

        upsertVenue(team.getVenue());
    }

    private static void upsertVenue(Venue venue) {
        if (venue.getID() == -1) return;
        Object[] values = {
                venue.getID(),
                venue.getName(),
                venue.getAddress(),
                venue.getCity(),
                venue.getCapacity(),
                venue.getSurface(),
                venue.getImage()
        };

        String query = "INSERT into dbo.venues(id, name, address, city, capacity, surface, image)"
                +  values(values);

        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(query);
        }

    }

    private static void upsertSeason(Season season, int leagueId) throws SQLException {
        Object [] values = {
            leagueId,
            season.getYear(),
            season.getStart(),
            season.getEnd(),
            season.getCurrent(),
            season.getCoverage().getEvents(),
            season.getCoverage().getLineups(),
            season.getCoverage().getStatisticsFixtures(),
            season.getCoverage().getStatisticsPlayers(),
            season.getCoverage().getStandings(),
            season.getCoverage().getPlayers(),
            season.getCoverage().getTopScorers(),
            season.getCoverage().getPredictions(),
            season.getCoverage().getOdds()
        };

        String query = "INSERT into dbo.seasons(LeagueId, [year], [start], [end], [current], coverageevents, coveragelineups, coveragestatisticsfixtures, coveragestatisticsplayers, "
                     + "coveragestandings, coverageplayers, coveragetopscorers, coveragepredictions, coverageodds) "
                     +  values(values);

        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(query);
        }
    }

    private static String values(Object[] values) {
        String str = "VALUES(";
        for (int i=0; i<values.length; i++) {
            if (values[i] == null) {
                str += "null";
            } else if (values[i].getClass().equals(String.class))  {
                String value = (String) values[i];
                value = value.replace("'", "''");
                str += "'"+value+"'";
            } else if (values[i].getClass().equals(Boolean.class)) {
                Boolean value = (Boolean) values[i];
                str += value == true ? "1" : "0";
            } else {
                str += values[i].toString();
            }

            if (i+1 != values.length) {
                str += ", ";
            }
        }
        str += ")";
        return str;
    }
}
