import org.springframework.security.authentication.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.LdapTemplate;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.authentication.LdapBindAuthenticator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;

import java.util.Arrays;
import java.util.Collection;

public class ProxyActiveDirectoryAuthenticationProvider implements AuthenticationProvider {

    private final LdapTemplate ldapTemplate;
    private final LdapAuthenticator ldapAuthenticator;
    private final UserDetailsService userDetailsService;

    public ProxyActiveDirectoryAuthenticationProvider(LdapTemplate ldapTemplate, LdapAuthenticator ldapAuthenticator, UserDetailsService userDetailsService) {
        this.ldapTemplate = ldapTemplate;
        this.ldapAuthenticator = ldapAuthenticator;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String proxyUser = "proxy-user"; // replace with your proxy user
        String proxyPassword = "proxy-password"; // replace with your proxy user's password
        String realUser = authentication.getName();
        String realUserPassword = authentication.getCredentials().toString();

        // Authenticate using the proxy user
        Authentication proxyAuth = ldapAuthenticator.authenticate(new ProxyAuthenticationToken(proxyUser, proxyPassword));

        // Check if the proxy user is authenticated
        if (!proxyAuth.isAuthenticated()) {
            throw new AuthenticationException("Proxy user authentication failed") {
            };
        }

        // Perform queries to validate the credentials of the real user
        UserDetails userDetails = userDetailsService.loadUserByUsername(realUser);

        if (userDetails != null && userDetails.getPassword().equals(realUserPassword)) {
            return new ProxyAuthenticationToken(userDetails, realUserPassword, userDetails.getAuthorities());
        } else {
            throw new AuthenticationException("Real user authentication failed") {
            };
        }
    }

    public static void main(String[] args) {
        // Example usage
        LdapTemplate ldapTemplate = new LdapTemplate();
        LdapAuthenticator ldapAuthenticator = new LdapBindAuthenticator(ldapTemplate.getContextSource());
        UserDetailsService userDetailsService = new LdapUserDetailsService(ldapTemplate);

        ProxyActiveDirectoryAuthenticationProvider provider = new ProxyActiveDirectoryAuthenticationProvider(ldapTemplate, ldapAuthenticator, userDetailsService);

        // Create a test authentication token
        Authentication testAuth = new ProxyAuthenticationToken("real-user", "real-password");

        // Authenticate
        try {
            Authentication result = provider.authenticate(testAuth);
            System.out.println("Authentication successful: " + result.isAuthenticated());
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}

class ProxyAuthenticationToken implements Authentication {

    private final String principal;
    private final String credentials;
    private boolean authenticated;
    private Collection<? extends GrantedAuthority> authorities;

    public ProxyAuthenticationToken(String principal, String credentials) {
        this.principal = principal;
        this.credentials = credentials;
        this.authenticated = false;
    }

    public ProxyAuthenticationToken(UserDetails userDetails, String credentials, Collection<? extends GrantedAuthority> authorities) {
        this.principal = userDetails.getUsername();
        this.credentials = credentials;
        this.authorities = authorities;
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return principal;
    }
}