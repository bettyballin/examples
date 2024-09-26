import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import java.util.Collection;
import java.util.List;

public class Temp1392 {

    private static LdapTemplate ldapTemplate;
    private static UserDetailsService userDetailsService;

    public static void main(String[] args) {

        // Dummy values for demonstration purposes
        String ldapUrl = "ldap://example.com";
        String baseDn = "dc=example,dc=com";
        String userDn = "cn=admin,dc=example,dc=com";
        String password = "password";

        // Set up LdapContextSource
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(ldapUrl);
        contextSource.setBase(baseDn);
        contextSource.setUserDn(userDn);
        contextSource.setPassword(password);
        contextSource.afterPropertiesSet();

        // Set up LdapTemplate
        ldapTemplate = new LdapTemplate(contextSource);

        // Assuming userDetailsService is initialized elsewhere
        userDetailsService = new DummyUserDetailsService();

        String userName = "exampleUsername";
        LdapQuery query = LdapQueryBuilder.query().where("uid").is(userName);
        List<LdapUserDetails> users = ldapTemplate.search(query, new UserDetailsContextMapper() {
            @Override
            public LdapUserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
                return (LdapUserDetails) userDetailsService.loadUserByUsername(username);
            }
        });
    }

    // Dummy UserDetailsService for demonstration purposes
    static class DummyUserDetailsService implements UserDetailsService {
        @Override
        public org.springframework.security.core.userdetails.User loadUserByUsername(String username) {
            return new org.springframework.security.core.userdetails.User(username, "", List.of());
        }
    }
}