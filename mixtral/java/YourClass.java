import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class YourClass {
    private MessageDigestPasswordEncoder messageDigestPasswordEncoder = new MessageDigestPasswordEncoder("MD5");

    // Or

    private Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();

    public static void main(String[] args) {
        YourClass instance = new YourClass();
        
        // Example usage
        String rawPassword = "password";
        String encodedPasswordMD5 = instance.messageDigestPasswordEncoder.encode(rawPassword);
        String encodedPasswordPbkdf2 = instance.pbkdf2PasswordEncoder.encode(rawPassword);

        System.out.println("MD5 Encoded Password: " + encodedPasswordMD5);
        System.out.println("PBKDF2 Encoded Password: " + encodedPasswordPbkdf2);
    }
}