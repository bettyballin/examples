import java.util.Base64;

public class Main3 {
    public static void main(String[] args) {
        String username = "user";
        String password = "pass";
        String userCredentials = username + ":" + password;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(userCredentials.getBytes());
        // Assuming huc is an HttpURLConnection object, it should be initialized here
        // HttpURLConnection huc = (HttpURLConnection) new URL("http://example.com").openConnection();
        // huc.setRequestProperty("Authorization", basicAuth);
    }
}