import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.support.LdapUserSearch;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapUserDetailsService;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;

public class Temp103 {

    @Autowired
    private LdapUserSearch ldapUserSearch;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    public static void main(String[] args) {
        Temp103 temp = new Temp103();
        temp.initialise();
    }

    public void initialise() {
        DirContextOperations dirContextOperations = ldapUserSearch.searchForUser("username");
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken("username", "password"));
    }

    @Autowired
    public void setLdapUserSearch(LdapContextSource contextSource) {
        this.ldapUserSearch = new FilterBasedLdapUserSearch("ou=users", "(uid={0})", contextSource);
    }

    @Autowired
    public void setAuthenticationProvider(LdapContextSource contextSource) {
        LdapUserDetailsService userDetailsService = new LdapUserDetailsService(ldapUserSearch, null);
        this.authenticationProvider = new LdapAuthenticationProvider(userDetailsService);
    }
}