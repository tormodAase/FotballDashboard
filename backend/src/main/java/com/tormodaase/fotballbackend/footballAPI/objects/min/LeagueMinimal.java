package main.java.com.tormodaase.fotballbackend.footballAPI.objects.min;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.League;
import org.json.JSONObject;

public class LeagueMinimal {
    private int id;
    private String name;
    private String type;
    private String logo;

    public LeagueMinimal(League league) {
        this.id = league.getID();
        this.name = league.getName();
        this.type = league.getType();
        this.logo = league.getLogo();
    }

    public LeagueMinimal(JSONObject json) {
        this.id = json.getInt("id");
        this.name = json.getString("name");
        this.type = json.getString("type");
        this.logo = json.getString("logo");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLogo() {
        return logo;
    }
}
