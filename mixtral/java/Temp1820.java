import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

import java.util.Collections;

@Configuration
public class LdapConfig {

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        return new DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org");
    }

    @Bean
    public AuthenticationManager ldapAuthenticationManager(@Autowired DefaultSpringSecurityContextSource context) {
        BindAuthenticator bindAuth = new BindAuthenticator(context);

        // Set up your custom user search filter
        FilterBasedLdapUserSearch userSearch =
            new FilterBasedLdapUserSearch("", "(&(uid={0})(objectclass=inetOrgPerson))", context);

        bindAuth.setUserSearch(userSearch);

        LdapAuthenticationProvider ldapAuthProvider = new LdapAuthenticationProvider(bindAuth);
        return new ProviderManager(Collections.singletonList(ldapAuthProvider));
    }
}