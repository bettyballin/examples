import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBCryptPasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return super.upgradeEncoding(encodedPassword);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        // Create salt or use a predefined one
        String salt = "customSalt";
        // Use the desired version prefix here (e.g $2b$)
        String password = rawPassword.toString() + salt;
        return super.encode(password);
    }

    public static void main(String[] args) {
        CustomBCryptPasswordEncoder encoder = new CustomBCryptPasswordEncoder();
        String encodedPassword = encoder.encode("myPassword");
        System.out.println("Encoded Password: " + encodedPassword);
    }
}