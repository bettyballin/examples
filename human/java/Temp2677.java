import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp2677 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        Temp2677 temp = new Temp2677();
        temp.run();
    }

    public void run() {
        String passwordPlanText = "password_plan_text_here";
        String encodedPassword = "encoded_password_here";

        boolean result = passwordEncoder.matches(passwordPlanText, encodedPassword);
        System.out.println("Password matches: " + result);
    }
}