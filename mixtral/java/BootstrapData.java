import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepo;

    // This method will execute after the context has been initialized
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (userRepo.count() == 0L) {
            createDefaultUsers();
        }
    }

    @Transactional
    private void createDefaultUsers() {
        // Create and save your default users here
        User user = new User("username", "password");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Save the users
        userRepo.save(user);
    }
}