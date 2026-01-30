import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class del {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://httpbin.org/delete");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
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
            System.out.println("error");
        }
    }
}
