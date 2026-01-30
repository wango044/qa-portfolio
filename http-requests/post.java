import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class post {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://httpbin.org/post");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);

        String jsonInput = "{\"title\":\"foo\", \"message\":\"hello\"}";

        try(OutputStream os = connection.getOutputStream()){
            byte[] input = jsonInput.getBytes("utf-8");

            os.write(input, 0, input.length);
        }
        int responceCode = connection.getResponseCode();

        System.out.println(responceCode);
        if(responceCode == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            reader.close();
        }else {
            System.out.println("Error" + responceCode);
        }
    }
}
