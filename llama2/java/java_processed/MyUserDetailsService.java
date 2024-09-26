import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Dummy CollaborateurFacade class to make the code executable
class CollaborateurFacade {
    // Dummy method
    public void doSomething() {
        // Implementation here
    }
}

// Configuration class to provide the CollaborateurFacade bean
@Configuration
class BeanConfig {

    @Bean
    @Primary
    public CollaborateurFacade getCollaborateurFacade() {
        return new CollaborateurFacade();
    }
}

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private BeanConfig beanConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Use the EJB reference from BeanConfig
        CollaborateurFacade collaborateurFacade = beanConfig.getCollaborateurFacade();
        collaborateurFacade.doSomething();
        // Return a dummy UserDetails object for demonstration purposes
        return User.withUsername(username)
                .password("password")
                .roles("USER")
                .build();
    }

    public static void main(String[] args) throws UsernameNotFoundException {
        MyUserDetailsService myUserDetailsService = new MyUserDetailsService();
        BeanConfig beanConfig = new BeanConfig();
        myUserDetailsService.beanConfig = beanConfig;
        UserDetails userDetails = myUserDetailsService.loadUserByUsername("username");
        System.out.println(userDetails);
    }
}