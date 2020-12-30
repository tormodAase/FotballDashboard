package com.tormodaase.footballAPI.SQL;

import com.tormodaase.footballAPI.objects.Country;

import java.sql.*;

public class DatabaseService {
    private static Connection connection;
    public static void connect(String connectionString, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(connectionString, username, password);
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
                +       "VALUES("
                +       String.join(",", values)
                +")";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
    }
}
