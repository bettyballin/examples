import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1288 extends WebSecurityConfigurerAdapter {

    private UserService userService; // Assume UserService is defined elsewhere

    public static void main(String[] args) {
        // Main method does not execute any security configuration
        System.out.println("Application started");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // For demonstration purposes only
    }

    // Assume UserService is defined elsewhere
    static class UserService {
        // UserService implementation
    }
}