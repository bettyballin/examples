import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Optional;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final UserService userService;

    public CustomJwtAuthenticationConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        AuthorizationServerUserId authorizationServerUserId = AuthorizationServerUserId.fromPrincipal(jwt);
        User user = userService.findByAuthorizationServerUserId(authorizationServerUserId)
                               .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + authorizationServerUserId));
        return new CustomAuthenticationToken(user, jwt.getTokenValue());
    }
}

class UserService {
    Optional<User> findByAuthorizationServerUserId(AuthorizationServerUserId userId) {
        // Implementation here...
        return Optional.empty();
    }
}

class User {
    // User properties and methods...
}

class AuthorizationServerUserId {
    static AuthorizationServerUserId fromPrincipal(Jwt jwt) {
        // Implementation here...
        return new AuthorizationServerUserId();
    }
}

class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String message) {
        super(message);
    }

    static UserNotFoundException forAuthorizationServerUserId(AuthorizationServerUserId id) {
        return new UserNotFoundException("User not found with ID: " + id);
    }
}

class CustomAuthenticationToken extends AbstractAuthenticationToken {
    private final User user;
    private final String token;

    CustomAuthenticationToken(User user, String token) {
        super(null);
        this.user = user;
        this.token = token;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }
}