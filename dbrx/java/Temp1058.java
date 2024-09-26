import java.util.Arrays;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1058 {
    public static void main(String[] args) {
        List<String> hashedPasswords = Arrays.asList("{bcrypt}hash1", "{bcrypt}hash2");
        Temp1058 temp = new Temp1058();
        temp.configure(new AuthenticationManagerBuilder(null), "username", "password", hashedPasswords);
    }

    protected void configure(AuthenticationManagerBuilder auth, String username, String password, List<String> hashedPasswords) throws Exception {
        for (String hashedPassword : hashedPasswords) {
            if (passwordEncoder().matches(password, hashedPassword)) {
                auth.inMemoryAuthentication()
                        .withUser(username)
                        .password(hashedPassword);
                break;
            }
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}