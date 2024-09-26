import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;
import java.security.Principal;

// Assuming ClientService and ClientDTO are defined somewhere else
public class YourController7 {

    private final ClientService clientService; // Assuming this is defined elsewhere

    public YourController7(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public Mono<ClientDTO> find(final Principal principal) {
        if (principal != null) {
            return clientService.findByMail(principal.getName());
        } else {
            throw new CustomTokenExpiredException();
        }
    }

    // Assuming CustomTokenExpiredException is a RuntimeException defined elsewhere
    public static class CustomTokenExpiredException extends RuntimeException {
        // Some implementation
    }
}