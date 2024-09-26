import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String argonString = "$argon2id$v=19$m=65536,t=10,p=1$BeHo0SdgM6vt5risz+yuLg$dOBFlfeoPPGCk/OLCGJ9sRhyPl0zMqMAUZvkltFWxnA";
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        
        String[] parts = argonString.split("\\$");
        byte[] hashBytes = Base64.getDecoder().decode(parts[5]);
        System.out.println("Hash: " + Base64.getEncoder().encodeToString(hashBytes));
    }
}