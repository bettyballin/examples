import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.security.cert.X509Certificate;

@Component
public class ClientCertificateAuthManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        if (!(authentication instanceof PreAuthenticatedAuthenticationToken))
            return Mono.empty();

        X509Certificate[] certificates = (X509Certificate[])
                ((PreAuthenticatedAuthenticationToken) authentication).getPrincipal();

        // Extract CN from the certificate
        String cn = extractCN(certificates[0]);

        if ("client1".equalsIgnoreCase(cn)) {
            return Mono.justOrEmpty(new PreAuthenticatedAuthenticationToken("ROLE_CLIENT1", null,
                    AuthorityUtils.createAuthorityList("ROLE_CLIENT1")));

        } else if ("client2".equalsIgnoreCase(cn)) {
            return Mono.justOrEmpty(new PreAuthenticatedAuthenticationToken("ROLE_CLIENT2", null,
                    AuthorityUtils.createAuthorityList("ROLE_CLIENT2")));
        }

        return Mono.empty();
    }

    private String extractCN(X509Certificate certificate) {
        // Implement certificate CN extraction logic here
        return "extractedCN"; // Placeholder implementation
    }
}