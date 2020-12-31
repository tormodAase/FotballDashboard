package main.java.com.tormodaase.fotballbackend.footballAPI.objects;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces.ITeam;
import org.json.JSONObject;

public class Team implements ITeam {
    private int id;
    private String name;
    private String country;
    private int founded;
    private boolean national;
    private String logo;
    private Venue venue;
    private JSONObject json;

    public Team(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        //TODO
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
    public String getJSONAsString() {
        return json.toString();
    }

    @Override
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
