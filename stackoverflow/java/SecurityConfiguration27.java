import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

public class SecurityConfiguration27 {
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .ldapAuthentication()
                .userSearchFilter("(sAMAccountName={0})")
                .groupSearchBase("ou=Mutual Ser")
                .contextSource(contextSource());
    }
    
    public DefaultSpringSecurityContextSource contextSource() {
        // Assuming the LDAP URL is "ldap://localhost:8389/dc=springframework,dc=org"
        return new DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org");
    }
}