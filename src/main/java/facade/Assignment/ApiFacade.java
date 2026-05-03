package facade.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = fetchJson(urlString);
        return parseAttribute(json, attributeName);
    }

    private String fetchJson(String urlString) throws IOException {
        URL url;

        try {
            url = new URL(urlString);
        } catch (Exception e) {
            throw new IOException("Invalid URL: " + urlString);
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int statusCode = connection.getResponseCode();
        if (statusCode != 200) {
            throw new IOException("HTTP request failed with status code: " + statusCode);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        } finally {
            connection.disconnect();
        }
    }

    private String parseAttribute(String json, String attributeName)
            throws IllegalArgumentException {

        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException(
                        "Attribute '" + attributeName + "' not found in JSON.");
            }

            Object value = jsonObject.get(attributeName);
            return value != null ? value.toString() : null;

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse JSON or extract attribute.");
        }
    }
}