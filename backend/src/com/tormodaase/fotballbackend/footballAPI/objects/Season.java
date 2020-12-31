package com.tormodaase.fotballbackend.footballAPI.objects;
import com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import com.tormodaase.fotballbackend.footballAPI.objects.interfaces.ISeason;
import org.json.JSONObject;

public class Season implements ISeason {
    private int year;
    private String start;
    private String end;
    private boolean current;
    private Coverage coverage;
    private JSONObject json;

    public Season(JSONObject json) throws JSONMismatchException {
        validateJSON(json);
        this.year = json.getInt("year");
        this.start = json.getString("start");
        this.end = json.getString("end");
        this.current = json.getBoolean("current");
        this.coverage = new Coverage(json.getJSONObject("coverage"));
        this.json = json;
    }


    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getStart() {
        return start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    @Override
    public boolean getCurrent() {
        return current;
    }

    @Override
    public Coverage getCoverage() {
        return coverage;
    }

    @Override
    public String getJSONAsString() {
        return json.toString();
    }

    @Override
    public JSONObject getJSON() {
        return json;
    }

    @Override
    public void validateJSON(JSONObject jsonObject) throws JSONMismatchException {
        //TODO
    }
}
