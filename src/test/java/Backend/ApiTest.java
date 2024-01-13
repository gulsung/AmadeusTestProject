package Backend;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiTest {

    OkHttpClient client = new OkHttpClient();
    String baseUrl = "https://flights-api.buraky.workers.dev/";

    @Test
    public void testStatusCode() throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(200, response.code());
        }
    }

    @Test
    public void testResponseStructure() throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertNotNull(response.body());
            String responseBody = response.body().string();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray flights = jsonResponse.getJSONArray("data");
            assertNotNull(flights);
            for (int i = 0; i < flights.length(); i++) {
                JSONObject flight = flights.getJSONObject(i);
                assertNotNull(flight.getInt("id"));
                assertNotNull(flight.getString("from"));
                assertNotNull(flight.getString("to"));
                assertNotNull(flight.getString("date"));
            }
        }
    }

    @Test
    public void testContentTypeHeader() throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals("application/json; charset=utf-8", response.header("Content-Type"));
        }
    }
}
