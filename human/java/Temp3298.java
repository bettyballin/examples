import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp3298 {
    public static void main(String[] args) {
        String keycloakHost = "http://<KEYCLOAK_HOST>";
        String realmName = "<REALM_NAME>";
        String urlString = keycloakHost + "/auth/admin/realms/" + realmName;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                System.out.println("Request was successful.");
            } else {
                System.out.println("GET request not worked.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}