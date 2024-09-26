import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp2596 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Key-Header", "public_key_here");
            connection.setRequestProperty("Content-Type", "application/something; utf8");
            connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.5.6");
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            connection.setRequestProperty("Connection", "close");
            connection.setDoOutput(true);

            String postData = "signature=signature";
            byte[] postDataBytes = postData.getBytes("UTF-8");
            connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

            try (OutputStream os = connection.getOutputStream()) {
                os.write(postDataBytes);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}