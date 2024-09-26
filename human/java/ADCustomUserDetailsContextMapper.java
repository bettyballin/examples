import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Collection;

public class ADCustomUserDetailsContextMapper extends LdapUserDetailsMapper {

    @Autowired
    private UserDetailsService userDetailsService; // ... the service used for DB authentication

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx,
                                          String username, Collection<? extends GrantedAuthority> authorities) {
        return userDetailsService.loadUserByUsername(username);
    }
}