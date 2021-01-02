package main.java.com.tormodaase.fotballbackend;

import main.java.com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import main.java.com.tormodaase.fotballbackend.footballAPI.FootballAPI;
import main.java.com.tormodaase.fotballbackend.footballAPI.SQL.DatabaseService;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Country;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.League;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Team;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JSONMismatchException, SQLException, EnvironmentVariableException, IOException {
		FootballAPI.getAPIKey();
		SpringApplication.run(Main.class, args);

	    DatabaseService.connect();
	    /*
	    Country[] countries = FootballAPI.getCountries();
	    for (int i=0; i<countries.length; i++) {
	    	System.out.println("Saving countries to database: "+i+"/"+countries.length);
	    	Country country = countries[i];
			DatabaseService.upsertCountry(country);
		}*/

		/*
		Team[] teams = FootballAPI.getTeams("country=Norway");
		for (int i=0; i<teams.length; i++) {
			System.out.println("Saving teams to database: "+i+"/"+teams.length);
			Team team = teams[i];
			DatabaseService.upsertTeam(team);
		}
		*/

		/*
		League[] leagues = FootballAPI.getLeagues();
	    for (int i=0; i<leagues.length; i++) {
			System.out.println("Saving leagues to database: "+i+"/"+leagues.length);
			League league = leagues[i];
			DatabaseService.upsertLeague(league);
		}

		 */
	    //DatabaseService.disconnect();

    }
}
