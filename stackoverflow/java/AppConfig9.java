import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;

public class AppConfig9 {

    @Bean
    @Primary
    public DefaultSpringSecurityContextSource contextSource() {
        String providerUrl = "your ldap url here";
        return new DefaultSpringSecurityContextSource(providerUrl);
    }

    @Bean("adUserDetailsManager")
    public UserDetailsManager getUserDetailsManager(DefaultSpringSecurityContextSource contextSource) {
        return new LdapUserDetailsManager(contextSource);
    }
}