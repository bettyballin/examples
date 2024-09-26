import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2452 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This is just a placeholder main method to make the class executable
        // The main method is not typically where you would configure beans in a Spring application
        System.out.println("Temp2452 is running");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}