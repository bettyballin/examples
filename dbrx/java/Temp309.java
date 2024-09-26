This is not Java code, it's a Spring configuration XML file. However, I will provide the equivalent Java configuration code that should compile without errors:


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;

@Configuration
@EnableWebSecurity
public class LdapSecurityConfig {

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldaps://your_ldap_server:636");
        contextSource.setUserDn("cn=manager,dc=springframework,dc=org");
        contextSource.setPassword("secret");
        return contextSource;
    }

    @Bean
    public LdapAuthenticationProvider ldapAuthProvider() {
        BindAuthenticator authenticator = new BindAuthenticator(contextSource());
        authenticator.setUserDnPatterns(new String[] {"uid={0},ou=Employees", "uid={0},ou=Clients"});

        DefaultLdapAuthoritiesPopulator populator = new DefaultLdapAuthoritiesPopulator(contextSource(), "");
        populator.setGroupSearchBase("ou=accessgroups,dc=springframework,dc=org");
        populator.setSearchSubtree(true);

        LdapAuthenticationProvider provider = new LdapAuthenticationProvider(authenticator, populator);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManagerBuilder builder = new AuthenticationManagerBuilder();
        builder.authenticationProvider(ldapAuthProvider());
        return builder.build();
    }
}