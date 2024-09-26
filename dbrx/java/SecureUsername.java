import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecureUsername {
    public static String getUsername() throws Exception {
        Process process = Runtime.getRuntime().exec("whoami");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine().trim();
    }

    public static void main(String[] args) {
        try {
            String username = getUsername();
            System.out.println("Username: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}