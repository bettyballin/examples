import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp1373 {
    @interface RolesAllowed {
        String value();
    }

    @RolesAllowed("SuperUser")
    public static void main(String[] args) {
        String urlString = "http://192.168.0.132/download.ws/special_path_pattern/fileid";
        
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Download successful.");
            } else {
                System.out.println("Download failed.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}