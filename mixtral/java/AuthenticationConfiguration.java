import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    LdapContextSource contextSource;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        // Create a custom filter
        String ldapFilter = "(| (uid={0}) (mail={1}))";

        auth
            .ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter(ldapFilter)
                .contextSource(contextSource);
    }
}