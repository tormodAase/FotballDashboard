package main.java.com.tormodaase.fotballbackend.footballAPI.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces.ITeam;
import org.json.JSONObject;

public class Team implements ITeam {
    private int id;
    private String name;
    private String country;
    private Integer founded;
    private boolean national;
    private String logo;
    private Venue venue;
    private JSONObject json;

    public Team(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        System.out.println(json.toString());
        this.id         = json.getJSONObject("team").getInt("id");
        this.name       = json.getJSONObject("team").getString("name");
        this.country    = json.getJSONObject("team").getString("country");
        this.founded    = json.getJSONObject("team").isNull("founded") ? -1 : json.getJSONObject("team").getInt("founded");
        this.national   = json.getJSONObject("team").getBoolean("national");
        this.logo       = json.getJSONObject("team").getString("logo");
        this.venue      = new Venue(json.getJSONObject("venue"));
        this.json       = json;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public int getFounded() {
        return founded;
    }

    @Override
    public boolean getNational() {
        return national;
    }

    @Override
    public String getLogo() {
        return logo;
    }

    @Override
    public Venue getVenue() {
        return venue;
    }

    @Override
    @JsonIgnore
    public String getJSONAsString() {
        return json.toString();
    }

    @Override
    @JsonIgnore
    public JSONObject getJSON() {
        return json;
    }

    public String toString() {
        return getJSONAsString();
    }

    @Override
    public void validateJSON(JSONObject jsonObject) throws JSONMismatchException {
        //TODO
    }
}
