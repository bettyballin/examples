import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager();
    }

}

@Repository
public interface UnsecuredUserRepo extends CrudRepository<UserDetails, Long> {
    UserDetails findByUsernameIgnoreCase(String username);
}

@Service
class BootstrapDataLoader implements ApplicationRunner {
    private final UserDetailsManager users;
    private final UnsecuredUserRepo repo;

    @Autowired
    public BootstrapDataLoader(UnsecuredUserRepo repo, UserDetailsService userDetailsService) {
        this.users = (UserDetailsManager) userDetailsService;
        this.repo = repo;

        // Create default admin user
        var admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        if (repo.findByUsernameIgnoreCase("ADMIN") == null) {
            users.createUser(admin);
        }
    }

    @Override
    public void run(ApplicationArguments args) {
       // No need to do anything here
    }
}