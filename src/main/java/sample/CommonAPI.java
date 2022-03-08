package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommonAPI {


    public static String getValueFromAPI(String apiURL, String key) {
        String value = null;
        HttpURLConnection connection = null;

        try {
            URL urlForGetRequest = new URL(apiURL);
            connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String readLine;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();

                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }

                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonResponseObject = jsonArray.getJSONObject(0);

                value = jsonResponseObject.optString(key);
            } else {
                value = "City Not Found";
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return value;
    }
}
