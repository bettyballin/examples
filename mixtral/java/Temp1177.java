import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp1177 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        Temp1177 temp = new Temp1177();
        temp.passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(temp.isOldPasswordCorrect("password", temp.passwordEncoder.encode("password")));
    }

    public boolean isOldPasswordCorrect(String oldPassword, String encodedOldPassword) {
        return passwordEncoder.matches(oldPassword, encodedOldPassword);
    }
}