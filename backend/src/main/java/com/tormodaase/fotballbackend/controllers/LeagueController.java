package main.java.com.tormodaase.fotballbackend.controllers;

import main.java.com.tormodaase.fotballbackend.footballAPI.SQL.DatabaseService;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.League;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Team;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.min.LeagueMinimal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeagueController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllLeagues")
    public League[] getAllLeagues(){
        System.out.println("/getAllLeagues");
        League[] leagues = DatabaseService.selectAllLeagues();
        return leagues;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllLeaguesMin")
    public LeagueMinimal[] getAllLeaguesMin(){
        System.out.println("/getAllLeaguesMin");
        LeagueMinimal[] leagues = DatabaseService.selectAllLeaguesMin();
        return leagues;
    }
}
