import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

// Assuming ClientDTO and CustomTokenExpiredException are defined somewhere in your project
class ClientDTO {
    // Define ClientDTO properties and methods
}

class CustomTokenExpiredException extends RuntimeException {
    public CustomTokenExpiredException() {
        super("Token has expired");
    }
}

// Assuming ClientService is defined somewhere in your project
interface ClientService {
    Mono<ClientDTO> findByMail(String email);
}

@RestController
public class Temp3102 {

    private final ClientService clientService;

    public Temp3102(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public Mono<ClientDTO> find(final Principal principal) {
        if (principal != null) {
            return this.clientService.findByMail(principal.getName());
        } else {
            throw new CustomTokenExpiredException();
        }
    }

    public static void main(String[] args) {
        // Spring Boot application code to start the server
        // SpringApplication.run(Temp3102.class, args);
    }
}