package com.tormodaase.fotballbackend.footballAPI.objects;

import com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import com.tormodaase.fotballbackend.footballAPI.objects.interfaces.ILeague;
import org.json.JSONObject;

public class League implements ILeague {
    private int id;
    private String name;
    private String type;
    private String logo;
    private Country country;
    private Season[] seasons;
    private JSONObject json;

    public League(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        this.id = json.getInt("id");
        this.name = json.getString("name");
        this.type = json.getString("type");
        this.logo = json.getString("logo");
        this.country = new Country (json.getJSONObject("country"));
        this.seasons = new Season[json.getJSONArray("seasons").length()];
        for (int i=0; i<seasons.length; i++) {
            seasons[i] = new Season(json.getJSONArray("seasons").getJSONObject(i));
        }
        this.json = json;
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
    public String getType() {
        return type;
    }

    @Override
    public String getLogo() {
        return logo;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    @Override
    public Season[] getSeasons() {
        return seasons;
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
