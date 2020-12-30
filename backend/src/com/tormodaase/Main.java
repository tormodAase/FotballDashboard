package com.tormodaase;

import com.tormodaase.footballAPI.SQL.DatabaseService;
import com.tormodaase.footballAPI.objects.Country;
import com.tormodaase.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JSONMismatchException, SQLException {
	    String connectionString = "";
	    String username = "a_FotballDashboard";
	    String password = "";
	    JSONObject json = new JSONObject();
	    json.put("name", "Norway");
	    json.put("code", "no");
	    json.put("flag", "TestValue");
	    Country country = new Country(json);

	    DatabaseService.connect(connectionString, username, password);
	    DatabaseService.upsertCountry(country);
	    DatabaseService.disconnect();

    }
}
