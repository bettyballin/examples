import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2299 {

    @Autowired
    private MyUserDetailsService userDetailsService;

    public static void main(String[] args) {
        // Your main application logic here
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(this.userDetailsService)
            .passwordEncoder(encodePasswd());
    }

    public PasswordEncoder encodePasswd() {
        return new BCryptPasswordEncoder();
    }

    // Dummy MyUserDetailsService class for illustration
    class MyUserDetailsService {
        // Implementation here
    }
}