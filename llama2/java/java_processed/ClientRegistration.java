import org.springframework.stereotype.Component;

public interface OAuth2ClientRegistration {
    String getClientId();
    String getClientSecret();
    boolean isUseJwtAssertion();
}

@Component
public class ClientRegistration implements OAuth2ClientRegistration {

    private final String clientId;
    private final String clientSecret;

    public ClientRegistration(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isUseJwtAssertion() {
        return false;
    }

    public static void main(String[] args) {
        ClientRegistration clientRegistration = new ClientRegistration("yourClientId", "yourClientSecret");
        System.out.println(clientRegistration.getClientId());
        System.out.println(clientRegistration.getClientSecret());
        System.out.println(clientRegistration.isUseJwtAssertion());
    }
}