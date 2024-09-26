import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.search.LdapUserSearch;

@Configuration
public class LdapConfig {

    @Bean
    public LdapUserSearch ldapUserSearch() {
        String baseDn = "OU=Users,DC=mydomain,DC=com";
        return new FilterBasedLdapUserSearch(baseDn, "(sAMAccountName={0})", contextSource());
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        return new DefaultSpringSecurityContextSource("ldap://myldapserver:389");
    }
}