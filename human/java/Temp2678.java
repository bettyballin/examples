import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2678 {
    public static void main(String[] args) {
        Temp2678 temp = new Temp2678();
        PasswordEncoder encoder = temp.passwordEncoder();
        String password = "myPassword";
        String encodedPassword = encoder.encode(password);
        System.out.println("Encoded password: " + encodedPassword);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}