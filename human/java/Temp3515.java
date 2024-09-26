import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp3515 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://server.example.com/token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic czZCaGRSa3F0MzpnWDFmQmF0M2JW");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String input = "grant_type=client_credentials";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                System.out.println("POST request worked");
            } else {
                System.out.println("POST request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}