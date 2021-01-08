package main.java.com.tormodaase.fotballbackend.controllers;

import main.java.com.tormodaase.fotballbackend.footballAPI.SQL.DatabaseService;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Team;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllTeams")
    public Team[] getAllTeams(){
        System.out.println("/getAllTeams");
        Team[] teams = DatabaseService.selectAllTeams();
        return teams;
    }
}
