import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.ldap.CommunicationException;

@Configuration
@EnableWebSecurity
public class Temp749 extends WebSecurityConfigurerAdapter {

    private final LdapAuthoritiesPopulator ldapAuthoritiesPopulator;
    private final CustomUserDetailsContextMapper mapper;

    public Temp749(LdapAuthoritiesPopulator ldapAuthoritiesPopulator, CustomUserDetailsContextMapper mapper) {
        this.ldapAuthoritiesPopulator = ldapAuthoritiesPopulator;
        this.mapper = mapper;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.ldapAuthentication()
                .userSearchFilter("(&(objectCategory=person)(objectClass=user)(sAMAccountName={0}))")
                .userSearchBase("DC=companyname,DC=com")
                .contextSource(contextSource())
                .userDetailsContextMapper(mapper)
                .ldapAuthoritiesPopulator(ldapAuthoritiesPopulator)
                .rolePrefix("");
        } catch (CommunicationException e) {
            // Handle the exception and provide fallback behavior here
            System.out.println("LDAP server is not available using alternative authentication method.");

            auth
              .inMemoryAuthentication()
              .withUser("fallbackuser")
              .password(encoder().encode("fallbackpass"))
              .roles("USER");
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    private LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:389");
        contextSource.setBase("DC=companyname,DC=com");
        contextSource.setUserDn("cn=admin,dc=companyname,dc=com");
        contextSource.setPassword("adminpassword");
        contextSource.afterPropertiesSet();
        return contextSource;
    }

    // You need to provide CustomUserDetailsContextMapper implementation
    public static class CustomUserDetailsContextMapper {
        // Implementation goes here
    }

    public static void main(String[] args) {
        System.out.println("Spring Security LDAP Configuration Example");
    }
}