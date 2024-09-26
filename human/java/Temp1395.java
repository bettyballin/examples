import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1395 {

    private PasswordEncoder delegate = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        Temp1395 temp = new Temp1395();
        String rawPass = "password123";
        String encPass = temp.delegate.encode(rawPass);
        System.out.println("Encoded Password: " + encPass);
        boolean isValid = temp.isPasswordValid(encPass, rawPass, null);
        System.out.println("Is password valid? " + isValid);
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        checkSalt(salt);
        return delegate.matches(rawPass, encPass);
    }

    private void checkSalt(Object salt) {
        if (salt != null) {
            throw new IllegalArgumentException("Salt value must be null");
        }
    }
}