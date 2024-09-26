import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LdapConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LdapConfig.class);

    private String adDomain = "yourDomain";
    private String adHost = "yourHost";
    private int adPort = 389; // Default LDAP port

    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        LOGGER.info("AD provider for domain {} on {}:{} ", adDomain, adHost, adPort);
        ActiveDirectoryLdapAuthenticationProvider provider =
            new ActiveDirectoryLdapAuthenticationProvider(adDomain, "ldap://" + adHost + ":" + adPort);

        // Set your custom ContextSource here
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://" + adHost + ":" + adPort);
        provider.setContextSource(contextSource);

        return provider;
    }

    @Bean(name = "adUserDetailsManager")
    public UserDetailsManager getUserDetailsManager() {
        // Use the same ContextSource as in your AuthenticationProvider
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://" + adHost + ":" + adPort);
        contextSource.afterPropertiesSet(); // Necessary to initialize the context source
        LdapUserDetailsManager userDetailsManager = new LdapUserDetailsManager(contextSource);
        return userDetailsManager;
    }
}