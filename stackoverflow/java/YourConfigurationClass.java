import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;

public class YourConfigurationClass {

    @Bean(name = "adUserDetailsManager")
    public UserDetailsManager getUserDetailsManager() throws Exception {
        String providerUrl = "your ldap url here";
        DefaultSpringSecurityContextSource contextSource 
                = new DefaultSpringSecurityContextSource(providerUrl);
        contextSource.afterPropertiesSet();
        return new LdapUserDetailsManager(contextSource);
    }
}