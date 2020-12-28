package com.tormodaase.footballAPI.objects.interfaces;

import com.tormodaase.footballAPI.objects.exceptions.JSONMismatchException;
import org.json.JSONObject;

public interface JSONInheritance {
    public String getJSONAsString();
    public JSONObject getJSON();
    public String toString();

    public void validateJSON(JSONObject jsonObject) throws JSONMismatchException;
}
