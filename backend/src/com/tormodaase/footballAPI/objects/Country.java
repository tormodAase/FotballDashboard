package com.tormodaase.footballAPI.objects;

import com.tormodaase.footballAPI.objects.exceptions.JSONMismatchException;
import com.tormodaase.footballAPI.objects.interfaces.ICountry;
import org.json.JSONObject;

public class Country implements ICountry {
    private String name;
    private String code;
    private String flag;
    private JSONObject json;

    public Country(JSONObject json) throws JSONMismatchException {
        this.validateJSON(json);
        this.name = json.getString("name");
        this.code = json.getString("code");
        this.flag = json.getString("flag");
        this.json = json;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getFlag() {
        return flag;
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
        if (jsonObject.getString("name") == null || jsonObject.getString("code") == null || jsonObject.getString("flag") == null) {
            throw new JSONMismatchException("ERROR: Cannot create object Country from JSON: "+jsonObject.toString());
        }
    }
}
