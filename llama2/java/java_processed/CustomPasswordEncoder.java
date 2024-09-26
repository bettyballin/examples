import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPass) {
        // Your custom encryption logic here
        String encryptedPassword = customEncrypt(rawPass.toString());
        return encryptedPassword;
    }

    @Override
    public boolean matches(CharSequence rawPass, String encPass) {
        // Your custom validation logic here
        String encryptedPassword = customEncrypt(rawPass.toString());
        return encryptedPassword.equals(encPass);
    }

    private String customEncrypt(String input) {
        // A very basic example of custom encryption (not secure for real use)
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        CustomPasswordEncoder encoder = new CustomPasswordEncoder();
        
        String rawPassword = "myPassword123";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Is password valid: " + encoder.matches(rawPassword, encodedPassword));
    }
}