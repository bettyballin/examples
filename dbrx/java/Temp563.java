import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.search.LdapUserSearch;

public class Temp563 {

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:8389");
        contextSource.setBase("dc=springframework,dc=org");
        contextSource.setUserDn("cn=admin,dc=springframework,dc=org");
        contextSource.setPassword("password");
        return contextSource;
    }

    @Bean
    public BindAuthenticator bindAuthenticator(LdapContextSource contextSource) {
        BindAuthenticator authenticator = new BindAuthenticator(contextSource);
        authenticator.setUserDnPatterns(new String[]{"uid={0},ou=people"});
        return authenticator;
    }

    @Bean
    public LdapUserSearch userSearch(LdapContextSource contextSource) {
        return new FilterBasedLdapUserSearch("ou=people", "(uid={0})", contextSource);
    }

    @Bean
    public LdapAuthenticationProvider ldapAuthenticationProvider(BindAuthenticator authenticator, LdapUserSearch userSearch) {
        return new LdapAuthenticationProvider(authenticator, userSearch);
    }

    public static void main(String[] args) {
        // Spring application context should be used to initialize the beans
    }
}