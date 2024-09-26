import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2994 {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encodedPassword = bCrypt.encode("randomPassword");
        System.out.println(encodedPassword);
    }
}