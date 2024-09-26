import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...
    }

    @Autowired
    public void configAuthManager(AuthenticationManagerBuilder auth, Environment env) throws Exception {

        DefaultSpringSecurityContextSource context =
                new DefaultSpringSecurityContextSource("ldap://your-server:port");

        // Set the referral property to "follow"
        context.setReferral("follow");

        auth
            .ldapAuthentication()
            .userSearchBase(env.getProperty("ldap.base"))
            .userSearchFilter(env.getProperty("ldap.search-filter"))
            // Set the custom LDAP ContextSource
            .contextSource(context)
            .managerDn(env.getProperty("ldap.admin.username"))
            .managerPassword(env.getProperty("ldap.admin.password"));
    }
}