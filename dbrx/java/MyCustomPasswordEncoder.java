import org.springframework.security.crypto.password.PasswordEncoder;

public class MyCustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    public static void main(String[] args) {
        MyCustomPasswordEncoder encoder = new MyCustomPasswordEncoder();
        String rawPassword = "password123";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Passwords match: " + encoder.matches(rawPassword, encodedPassword));
    }
}