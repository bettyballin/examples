import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserCredential {
    private org.springframework.security.oauth2.client.DefaultOAuth2ClientContext clientContext;

    // Getter and Setter for clientContext
    public org.springframework.security.oauth2.client.DefaultOAuth2ClientContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(org.springframework.security.oauth2.client.DefaultOAuth2ClientContext clientContext) {
        this.clientContext = clientContext;
    }
}