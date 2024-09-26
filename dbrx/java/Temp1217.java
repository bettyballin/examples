import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1217 {
    public static void main(String[] args) {
        Temp1217 temp = new Temp1217();
        PasswordEncoder encoder = temp.passwordEncoder();
        String encodedPassword = encoder.encode("myPassword");
        System.out.println("Encoded password: " + encodedPassword);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}