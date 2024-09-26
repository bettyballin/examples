import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration9 {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .ldapAuthentication()
                .userDnPatterns("cn={0},ou=...,ou=...,o=...,c=...")
                .contextSource()
                    .url("ldaps://server:636")
                    .managerDn("cn=...,ou=...,o=...,c=...")
                    .managerPassword("...");
    }
}