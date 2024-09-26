import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1749 {
    public static void main(String[] args) {
        try {
            AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);
            auth
                .inMemoryAuthentication()
                    .withUser("janedoe")
                        .password(encoder().encode("qwe"))
                        // Note the ROLE_* prefix
                        .roles("ROLE_ADMIN", "ROLE_USER");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}