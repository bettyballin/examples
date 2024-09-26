import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

public class Temp3161 {
    public static void main(String[] args) {
        Temp3161 temp = new Temp3161();
        ContextSource contextSource = temp.contextSource();
        UserDetailsManager userDetailsManager = temp.getUserDetailsManager(contextSource);
        // Additional code to use userDetailsManager
    }

    @Bean
    @Primary
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("your ldap url here");
        contextSource.afterPropertiesSet(); // Initialize the context source
        return contextSource;
    }

    @Bean("adUserDetailsManager")
    public UserDetailsManager getUserDetailsManager(LdapContextSource contextSource) {
        return new LdapUserDetailsManager(contextSource);
    }
}