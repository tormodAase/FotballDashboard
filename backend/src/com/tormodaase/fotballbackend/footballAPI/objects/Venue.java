package com.tormodaase.fotballbackend.footballAPI.objects;

import com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import com.tormodaase.fotballbackend.footballAPI.objects.interfaces.IVenue;
import org.json.JSONObject;

public class Venue implements IVenue {
    private int id;
    private String name;
    private String address;
    private String city;
    private int capacity;
    private String surface;
    private String image;
    private JSONObject json;

    public Venue(JSONObject json) {
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
    public String getAddress() {
        return address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getSurface() {
        return surface;
    }

    @Override
    public String getImage() {
        return image;
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
