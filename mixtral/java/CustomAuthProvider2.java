import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

public class CustomAuthProvider implements AuthenticationProvider, ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws BadCredentialsException {
        try {
            return authenticateWithCredentials(authentication);
        } catch (Exception e) {
            eventPublisher.publishEvent(new BadCredentialsEvent(authentication));
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Implement your logic to determine if the provider supports the given authentication type
        return true;
    }

    private Authentication authenticateWithCredentials(Authentication authentication) throws Exception {
        // Implement your authentication logic here
        return null;
    }
}

class BadCredentialsEvent {
    private final Authentication authentication;

    public BadCredentialsEvent(Authentication authentication) {
        this.authentication = authentication;
    }

    public Authentication getAuthentication() {
        return authentication;
    }
}