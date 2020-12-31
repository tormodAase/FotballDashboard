package com.tormodaase.fotballbackend;

import com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import com.tormodaase.fotballbackend.footballAPI.SQL.DatabaseService;
import com.tormodaase.fotballbackend.footballAPI.objects.Country;
import com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JSONMismatchException, SQLException, EnvironmentVariableException {
	    JSONObject json = new JSONObject();
	    json.put("name", "Norway");
	    json.put("code", "no");
	    json.put("flag", "TestValue");
	    Country country = new Country(json);

	    DatabaseService.connect();
	    DatabaseService.upsertCountry(country);
	    DatabaseService.disconnect();

    }
}
