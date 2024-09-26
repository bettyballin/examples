import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class Temp531 {

    @Autowired
    private UserDetailsService employerUserService;

    @Autowired
    private UserDetailsService employeeUserService;

    @Bean
    public DaoAuthenticationProvider employerAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(employerUserService);
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider employeeAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(employeeUserService);
        return provider;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp531.class);
        context.close();
    }
}