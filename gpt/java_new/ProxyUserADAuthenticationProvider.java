import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ProxyUserADAuthenticationProvider implements AuthenticationProvider {

    private String proxyUserDn;
    private String proxyPassword;
    private ActiveDirectoryLdapAuthenticationProvider adProvider;

    public ProxyUserADAuthenticationProvider(String domain, String url, String proxyUserDn, String proxyPassword) {
        this.proxyUserDn = proxyUserDn;
        this.proxyPassword = proxyPassword;
        this.adProvider = new ActiveDirectoryLdapAuthenticationProvider(domain, url);
        this.adProvider.setConvertSubErrorCodesToExceptions(true);
        this.adProvider.setUseAuthenticationRequestCredentials(true);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Custom implementation that uses the proxy user credentials
        // authentication logic here
        return null; // Replace null with actual Authentication result
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    // Getters and Setters for proxyUserDn and proxyPassword if necessary
}