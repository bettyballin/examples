import java.time.Instant;

public class CustomJwtExpiryBearerTokenRenderer implements BearerTokenRenderer {

    @Override
    public AccessRefreshToken render(Integer defaultExpiresIn, String accessToken, String refreshToken) {
        // Set your custom expiration time here
        int customValue = 60 * 15;

        return new DefaultAccessRefreshToken(accessToken,
                refreshToken,
                "Bearer",
                Instant.now().plusSeconds((long) customValue));
    }
}

interface BearerTokenRenderer {
    AccessRefreshToken render(Integer defaultExpiresIn, String accessToken, String refreshToken);
}

class DefaultAccessRefreshToken implements AccessRefreshToken {
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final Instant expiresAt;

    public DefaultAccessRefreshToken(String accessToken, String refreshToken, String tokenType, Instant expiresAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public String getTokenType() {
        return tokenType;
    }

    @Override
    public Instant getExpiresAt() {
        return expiresAt;
    }
}

interface AccessRefreshToken {
    String getAccessToken();
    String getRefreshToken();
    String getTokenType();
    Instant getExpiresAt();
}