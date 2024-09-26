import java.util.Base64;

public class Temp1637 {
    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";
        
        String auth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        System.out.println("Authorization: Basic " + auth);
        
        // Uncomment and add the correct library to use Unirest
        // Unirest.setDefaultHeader("Authorization", "Basic " + auth);
    }
}