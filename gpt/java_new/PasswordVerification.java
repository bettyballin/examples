import java.nio.charset.StandardCharsets;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordVerification {
    public static void main(String[] args) {
        String arg2JvmHash = "argon2_hash_here"; // replace with the actual Argon2 hash
        String springBouncyHash = "spring_hash_here"; // replace with the actual Spring Security hash
        String rawPass = "your_password"; // replace with the password to verify

        // Verify with Argon2 (assuming argon2jvm is an instance of Argon2)
        Argon2 argon2jvm = Argon2Factory.create();
        boolean matchesArgon2 = argon2jvm.verify(arg2JvmHash, rawPass.getBytes(StandardCharsets.UTF_8));

        // Verify with Spring Security (assuming arg2SpringSecurity is an instance of BCryptPasswordEncoder)
        BCryptPasswordEncoder arg2SpringSecurity = new BCryptPasswordEncoder();
        boolean matchesSpring = arg2SpringSecurity.matches(rawPass, springBouncyHash);

        System.out.println("Argon2 verification result: " + matchesArgon2);
        System.out.println("Spring Security verification result: " + matchesSpring);
    }
}