package main.java.com.tormodaase.fotballbackend.footballAPI.objects;

import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces.IVenue;
import org.json.JSONObject;

public class Venue implements IVenue {
    private int id;
    private String name;
    private String address;
    private String city;
    private Integer capacity;
    private String surface;
    private String image;
    private JSONObject json;

    public Venue(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        this.id =       json.isNull("id") ? -1 : json.getInt("id");
        this.name =     json.isNull("name") ? null : json.getString("name");
        this.address =  json.isNull("address") ? null : json.getString("address");
        this.city =     json.isNull("city") ? null : json.getString("city");
        this.capacity = json.isNull("capacity") ? -1 : json.getInt("capacity");
        this.surface =  json.isNull("surface") ? null : json.getString("surface");
        this.image =    json.isNull("image") ? null : json.getString("image");
        this.json =     json;
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
