package main.java.com.tormodaase.fotballbackend;

import main.java.com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import main.java.com.tormodaase.fotballbackend.footballAPI.FootballAPI;
import main.java.com.tormodaase.fotballbackend.footballAPI.SQL.DatabaseService;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Country;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JSONMismatchException, SQLException, EnvironmentVariableException, IOException {
		FootballAPI.getAPIKey();
		Country[] countries = FootballAPI.getCountries();

	    DatabaseService.connect();
	    for (int i=0; i<countries.length; i++) {
	    	System.out.println("Saving countries to database: "+i+"/"+countries.length);
	    	Country country = countries[i];
			DatabaseService.upsertCountry(country);
		}
	    DatabaseService.disconnect();

    }
}
