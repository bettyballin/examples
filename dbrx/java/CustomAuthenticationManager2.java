import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import java.security.Principal;
import java.security.cert.X509Certificate;

@Component("customAuthenticationManager")
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserDetailsService ldapAuthenticator;

    @Override
    public Authentication authenticate(Authentication authentication) {
        X509Certificate certificate = (X509Certificate) authentication.getCredentials();
        String cn = extractCNFromCert(certificate);
        try {
            UserDetails userDetails = this.ldapAuthenticator.loadUserByUsername(cn);
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String extractCNFromCert(X509Certificate cert) {
        try {
            Principal principal = cert.getSubjectDN();
            String name = principal.getName();

            LdapName ldapDN = new LdapName(name);
            for (Rdn rdn : ldapDN.getRdns()) {
                if ("CN".equalsIgnoreCase(rdn.getType())) {
                    return rdn.getValue().toString();
                }
            }
        } catch (InvalidNameException e) {
            throw new RuntimeException("Invalid certificate name", e);
        }

        throw new RuntimeException("No CN found in certificate");
    }
}