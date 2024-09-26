import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp1518 extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .ldapAuthentication()
                // User Base DN
                .userDnPatterns("cn={0},ou=...,ou=...,o=...,c=...") 
                .contextSource()
                    // ldap server
                    .url("ldaps://server:636") 
                    // Bind credentials Bind DN
                    .managerDn("cn=...,ou=...,o=...,c=...") 
                    // Bind credentials Bind Password
                    .managerPassword("...");
    }

    public static void main(String[] args) {
        // Spring Boot applications usually have a main method to launch the application
        // SpringApplication.run(Temp1518.class, args);
        // For this example, main method is not necessary
    }
}