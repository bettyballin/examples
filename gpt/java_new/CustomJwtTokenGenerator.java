import io.micronaut.security.token.jwt.generator.AccessTokenConfiguration;
import io.micronaut.security.token.jwt.generator.JwtTokenGenerator;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class CustomJwtTokenGenerator extends JwtTokenGenerator {

    private final int customExpirationInSeconds;

    public CustomJwtTokenGenerator(AccessTokenConfiguration accessTokenConfiguration,
                                   int customExpirationInSeconds) {
        super(accessTokenConfiguration);
        this.customExpirationInSeconds = customExpirationInSeconds;
    }

    @Override
    protected Optional<Integer> getExpiration() {
        return Optional.of(customExpirationInSeconds);
    }
}