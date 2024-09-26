import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.SecureRandom;

public class Temp1111 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, random);
        String encodedPwd = encoder.encode("password");
        boolean matches = encoder.matches("password", encodedPwd);
        System.out.println(encodedPwd + " : " + matches);
    }
}