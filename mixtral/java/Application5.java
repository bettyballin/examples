import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Application implements CommandLineRunner {

    @Autowired
    private SecuredService securedService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        securedService.onlyAdminMethod();
        securedService.onlyAdminMetod2();
    }
}

@Service
class SecuredService {

    @Secured("ROLE_ADMIN")
    public void onlyAdminMethod() {
        System.out.println("Admin-only method called");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void onlyAdminMetod2() {
        System.out.println("Admin-only method 2 called");
    }
}