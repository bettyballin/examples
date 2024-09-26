import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class Temp1202 {

    private final UserDetailsService userDetailsService;

    @Autowired
    public Temp1202(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }

    public static void main(String[] args) {
        // Spring Boot application would be required to run this, not just a main method.
        // This main method is only for demonstration purposes.
        System.out.println("Configure Spring Security Authentication");
    }
}