package main.java.com.tormodaase.fotballbackend.footballAPI.objects;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.interfaces.ISeason;
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
        try {
            this.year = json.getInt("year");
            this.start = json.isNull("start") ? null : json.getString("start");
            this.end = json.isNull("end") ? null : json.getString("end");
            this.current = json.getBoolean("current");
            this.coverage = new Coverage(json.getJSONObject("coverage"));
            this.json = json;
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(json);
        }
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
