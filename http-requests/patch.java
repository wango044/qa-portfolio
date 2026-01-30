import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class patch {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://httpbin.org/patch");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PATCH");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);


        String jsonInput = "{\"email\":\"new_email@example.com\"}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}