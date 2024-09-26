import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp3257 extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .ldapAuthentication()
                .userSearchFilter("(&(objectClass=person)(objectClass=user)(sAMAccountName={0})(|(memberOf=cn=inventadmin,OU=inventorization,OU=Groups,OU=nsk,DC=office,DC=ru)(memberOf=cn=inventuser,OU=inventorization,OU=Groups,OU=nsk,DC=office,DC=ru)))")
                .userSearchBase("OU=Active,OU=Users,OU=nsk,DC=office,DC=ru")
                .groupSearchBase("OU=inventorization,OU=Groups,OU=nsk,DC=office,DC=ru")
                .groupSearchFilter("(member={0})")
                .contextSource()
                .url("ldap://office.ru:389")
                .managerDn("CN=ldap_user_ro,OU=Service,OU=Users,OU=nsk,DC=office,DC=ru")
                .managerPassword("password");
    }

    public static void main(String[] args) {
        // Normally Spring Boot application would be started here
        System.out.println("Spring Security LDAP Configuration Loaded.");
    }
}