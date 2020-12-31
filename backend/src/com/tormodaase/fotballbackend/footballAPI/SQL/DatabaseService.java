package com.tormodaase.fotballbackend.footballAPI.SQL;

import com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import com.tormodaase.fotballbackend.footballAPI.objects.Country;

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
        //TODO
        String[] values = {country.getName(), country.getCode(), country.getFlag()};
        String query = "INSERT into dbo.countries(name, code, flag)"
                +       "VALUES('"
                +       String.join("','", values)
                +"')";

        Statement stmt = connection.createStatement();
        boolean result = stmt.execute(query);
    }
}
