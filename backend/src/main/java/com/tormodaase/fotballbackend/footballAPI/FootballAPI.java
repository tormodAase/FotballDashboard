package main.java.com.tormodaase.fotballbackend.footballAPI;

import main.java.com.tormodaase.fotballbackend.environment.exceptions.EnvironmentVariableException;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.Country;
import main.java.com.tormodaase.fotballbackend.footballAPI.objects.exceptions.JSONMismatchException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.prefs.Preferences;

public class FootballAPI {
    private static String APIKEY;

    public static void getAPIKey() throws EnvironmentVariableException {
        Preferences prefs = Preferences.systemRoot().node("com/tormodaase/fotballbackend");
        String apiKey = prefs.get("api_key", null);
        if (apiKey == null) {
            String errorMessage = "Variable(s) not found. Please run SetEnvironmentVariables. ";
            errorMessage += "API Key: "   + (apiKey == null ? "NULL" : "DEFINED");
            throw new EnvironmentVariableException(errorMessage);
        }
        APIKEY = apiKey;
    }

    public static Country[] getCountries() throws IOException, JSONMismatchException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://v3.football.api-sports.io/countries")
                .method("GET", null)
                .addHeader("x-rapidapi-host", "v3.football.api-sports.io")
                .addHeader("x-rapidapi-key", APIKEY)
                .build();
        Response response = client.newCall(request).execute();

        JSONObject responseBody = new JSONObject(response.body().string());
        JSONArray jsonArray = responseBody.getJSONArray("response");
        Country[] countries = new Country[jsonArray.length()];
        for (int i=0; i<countries.length; i++) {
            try {
                countries[i] = new Country(jsonArray.getJSONObject(i));
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }

        return countries;
    }
}
