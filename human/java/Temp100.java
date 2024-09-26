import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;

import java.util.Collections;

@Configuration
public class LdapConfig {

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = 
            new DefaultSpringSecurityContextSource("ldap://localhost:389/cn=Sandbox,dc=ITOrg");
        contextSource.setUserDn("cn=superuser,cn=People,cn=Sandbox,dc=ITOrg");
        contextSource.setPassword("xxxxxx");
        return contextSource;
    }

    @Bean
    public LdapAuthenticationProvider ldapAuthProvider() {
        BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource());
        bindAuthenticator.setUserDnPatterns(new String[]{"cn={0},cn=People"});
        
        return new LdapAuthenticationProvider(bindAuthenticator);
    }

    @Bean
    public FilterBasedLdapUserSearch userSearch() {
        return new FilterBasedLdapUserSearch("cn=People", "(cn={0})", contextSource());
    }
}