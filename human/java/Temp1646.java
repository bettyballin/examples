import java.util.Base64;

public class Temp1646 {
    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";
        String authString = username + ":" + password;
        String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
        System.out.println("Authorization: Basic " + authStringEnc);
    }
}