import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class UserResource {

    @GetMapping("/user")
    public String getCurrentUser() {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        return "Username: " + principal.getKeycloakSecurityContext().getIdToken().getName() +
                " Email: " + principal.getKeycloakSecurityContext().getIdToken().getEmail();
    }
}