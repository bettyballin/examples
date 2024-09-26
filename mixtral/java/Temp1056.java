import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
public class Temp1056 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LdapContextSource contextSource = new LdapContextSource();
        // ... set up the ldap properties

        CustomLdapAuthoritiesPopulator authoritiesPopulator = new CustomLdapAuthoritiesPopulator();
        
        DefaultSpringSecurityContextSource contextSourceWrapper = new DefaultSpringSecurityContextSource(contextSource);

        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldap = auth.ldapAuthentication()
                .userSearchFilter("cn={0}")
                .groupSearchBase("OU=Account Groups,OU=ITS Security")
                // Remove the group search filter from here
                .contextSource(contextSourceWrapper);

        ldap.ldapAuthoritiesPopulator(authoritiesPopulator);
    }

    // Dummy CustomLdapAuthoritiesPopulator class for compilation
    public class CustomLdapAuthoritiesPopulator {
        // Implementation details would go here
    }

    // Dummy main method to run the application
    public static void main(String[] args) {
        System.out.println("Application started");
    }
}