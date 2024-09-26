import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"your.package"})
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private StartupDataLoader startupDataLoader;

    @Override
    public void run(String... args) throws Exception {
        // This will trigger the onApplicationEvent method manually
        startupDataLoader.onApplicationEvent(null);
    }
}

@Component
class StartupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private YourRepository userRepo;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (userRepo.count() == 0) {
            UserDetails admin = new AdminUser("admin@example.com", "password");

            this.userRepo.save((AdminUser) admin);

            // Create other users here
        }
    }
}

// Assuming you have the following classes and interfaces

interface YourRepository {
    long count();
    <S extends UserDetails> S save(S entity);
}

class AdminUser implements UserDetails {
    private String email;
    private String password;

    public AdminUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Implement other methods from UserDetails interface
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}