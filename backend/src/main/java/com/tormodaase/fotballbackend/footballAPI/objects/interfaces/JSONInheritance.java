package main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;

public interface JSONInheritance {
    @JsonIgnore
    public String getJSONAsString();
    @JsonIgnore
    public JSONObject getJSON();
    public String toString();

    public void validateJSON(JSONObject jsonObject) throws JSONMismatchException;
}
