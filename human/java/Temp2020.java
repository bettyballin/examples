import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2020 {
    private static final PasswordEncoder _stringDigester = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        Temp2020 temp = new Temp2020();
        String newPassword = "myNewPassword";
        String passwordFromDb = _stringDigester.encode("myNewPassword");

        boolean isMatch = temp.isPasswordsMatch(newPassword, passwordFromDb);
        System.out.println("Do passwords match? " + isMatch);
    }

    public boolean isPasswordsMatch(String newPassword, String passwordFromDb) {
        return _stringDigester.matches(newPassword, passwordFromDb);
    }
}