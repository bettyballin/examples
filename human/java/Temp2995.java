import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2995 {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String randomPassword = "examplePassword";
        String encodedPassword = bCrypt.encode(randomPassword);
        System.out.println("Encoded password: " + encodedPassword);
    }
}