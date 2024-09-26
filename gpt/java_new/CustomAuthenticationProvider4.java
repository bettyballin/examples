import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.NullLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;

import java.util.Collection;

public class CustomAuthenticationProvider4 implements AuthenticationProvider {

    private LdapAuthenticationProvider ldapProvider;

    public CustomAuthenticationProvider4(LdapUserDetailsService userDetailsService) {
        LdapAuthoritiesPopulator authoritiesPopulator = new NullLdapAuthoritiesPopulator();
        this.ldapProvider = new LdapAuthenticationProvider(userDetailsService, authoritiesPopulator);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return ldapProvider.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    // Additional methods and fields if necessary
}