import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp2625 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/api/authentication");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String data = "username=" + "your_email" + "&password=" + "your_password";
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}