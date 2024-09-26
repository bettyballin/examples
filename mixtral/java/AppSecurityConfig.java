import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.PasswordComparisonAuthenticator;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.userdetails.LdapUserSearch;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://localhost:389/dc=springframework,dc=org");
        contextSource.afterPropertiesSet();

        LdapUserSearch ldapUserSearch = new FilterBasedLdapUserSearch("", "(&(uid={0})(objectclass=person))", contextSource);

        BindAuthenticator bindAuth = new BindAuthenticator(contextSource);
        bindAuth.setUserSearch(ldapUserSearch);

        PasswordComparisonAuthenticator passwordCompare = new PasswordComparisonAuthenticator(contextSource);
        passwordCompare.setPasswordEncoder(new MessageDigestPasswordEncoder("MD5"));

        LdapAuthenticationProvider ldapAuthProvider = new LdapAuthenticationProvider(bindAuth, passwordCompare);

        auth.authenticationProvider(ldapAuthProvider);
    }
}