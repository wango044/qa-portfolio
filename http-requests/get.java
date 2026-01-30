import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class get {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://httpbin.org/get");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responceCode = connection.getResponseCode();

        System.out.println(responceCode);

        if (responceCode == HttpURLConnection.HTTP_OK){
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
