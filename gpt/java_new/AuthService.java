import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import reactor.core.publisher.Mono;

public class AuthService {

    public Mono<Void> updateAuthentication(MyAppUserDetails updatedUserDetails) {
        return ReactiveSecurityContextHolder.getContext()
            .map(SecurityContext::getAuthentication)
            .flatMap(authentication -> {
                Authentication newAuthentication = new UsernamePasswordAuthenticationToken(
                        updatedUserDetails,
                        authentication.getCredentials(),
                        authentication.getAuthorities());
                return ReactiveSecurityContextHolder.withAuthentication(newAuthentication);
            })
            .then();
    }
    
    // Assuming MyAppUserDetails is defined somewhere
    public class MyAppUserDetails {
        // User details implementation
    }
}