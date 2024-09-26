import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<Client> createClient(@PathVariable String companyId, HttpServletRequest request) throws IOException {
        // Generate clientId and clientSecret using the service.
        String clientId = clientService.generateClientId();
        String clientSecret = clientService.generateClientSecret();

        // Save the generated values to your database along with the provided companyId.

        return ResponseEntity.ok().body(new Client(clientId, clientSecret));
    }
}

class Client {
    private String clientId;
    private String clientSecret;

    public Client(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    // Getters and setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}

interface ClientService {
    String generateClientId();
    String generateClientSecret();
}