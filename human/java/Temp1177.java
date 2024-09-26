import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


@Component
public class Temp1177 extends WebSecurityConfigurerAdapter {

    private final MutiboUserDetailsService mutiboUserDetailsService;

    public Temp1177(MutiboUserDetailsService mutiboUserDetailsService) {
        this.mutiboUserDetailsService = mutiboUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mutiboUserDetailsService);
    }

    public static void main(String[] args) {
        // Your application entry point logic here
        System.out.println("Application started");
    }
}

// Dummy service class, replace with your actual implementation
class MutiboUserDetailsService {
    // Your user details service implementation
}