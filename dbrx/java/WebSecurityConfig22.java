import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.LdapAuthenticationProviderConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldap = auth.ldapAuthentication();

        // Set the context source for LDAP server connection details.
        ldap.contextSource()
            .url("ldap://aaa:54389/dc=xxx,dc=com")
            .managerDn("")
            .managerPassword("");

        // Configure user search filter and group role attribute settings.
        ldap.userSearchFilter("(sAMAccountName={0})")
            .userSearchBase("dc=xxx,dc=com");

        ldap.groupRoleAttribute("cn")
            .groupSearchBase("OU=Groups,DC=xxx,DC=com")
            .groupSearchFilter("(member={0})");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuration for Redirects Login-Page and stuff

        http
            .authorizeRequests()
                .antMatchers("/admincare").authenticated()
                .and()
            .formLogin();
            // .loginPage("/auth/login")
            // .permitAll();     
    }
}