// This snippet seems to represent XML configuration for LDAP authentication, possibly in a Spring application context.
// It cannot be directly refactored into a compilable Java code snippet without more context.
// However, I can provide an example of how it might be translated into a Spring Security Java configuration:

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class LdapSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        LdapAuthenticationProvider ldapAuthProvider = new ActiveDirectoryLdapAuthenticationProvider("example.com", "ldap://example.com/");
        ldapAuthProvider.setUserSearchFilter("(cn={0})");
        ldapAuthProvider.setUserSearchBase("dc=example,dc=com");
        ldapAuthProvider.setGroupSearchFilter("(member={0})");
        ldapAuthProvider.setGroupSearchBase("dc=example,dc=com");
        ldapAuthProvider.setGroupRoleAttribute("cn");
        ldapAuthProvider.setRolePrefix("ROLE_");
        // Assuming userContextMapper is a bean of type UserDetailsContextMapper
        // ldapAuthProvider.setUserDetailsContextMapper(userContextMapper);
        auth.authenticationProvider(ldapAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }
}