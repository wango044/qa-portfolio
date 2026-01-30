import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class put {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://httpbin.org/put");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);

        String jsonInput = "{\"title\":\"foo\", \"message\":\"world\"}";

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
