import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<Cliente> cliente = clienteRepository.findById(clientId);
        if (cliente.isEmpty()) {
            throw new ClientRegistrationException("Client not found: " + clientId);
        }

        Cliente client = cliente.get();
        return new ClienteDetalhes(
                client.getClientId(),
                String.join(",", client.getResourceIds()),
                client.getClientSecret(),
                String.join(",", client.getScope()),
                String.join(",", client.getAuthorizedGrantTypes()),
                String.join(",", client.getRegisteredRedirectUri()),
                null,
                client.getAccessTokenValiditySeconds(),
                client.getRefreshTokenValiditySeconds(),
                client.getAutoApproveScope(),
                null);
    }
}