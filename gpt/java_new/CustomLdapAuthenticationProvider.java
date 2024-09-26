import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;

import javax.naming.CommunicationException;
import java.net.UnknownHostException;

@Component
public class CustomLdapAuthenticationProvider implements AuthenticationProvider {

    private final LdapAuthenticationProvider ldapAuthenticationProvider;

    @Autowired
    public CustomLdapAuthenticationProvider(LdapAuthenticationProvider ldapAuthenticationProvider) {
        this.ldapAuthenticationProvider = ldapAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            return ldapAuthenticationProvider.authenticate(authentication);
        } catch (InternalAuthenticationServiceException e) {
            Throwable cause = e.getCause();
            if (cause instanceof CommunicationException || cause instanceof UnknownHostException) {
                // Fallback logic
            }
            throw e;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ldapAuthenticationProvider.supports(authentication);
    }
}