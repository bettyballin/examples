import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.ldap.core.DirContextOperations;
import java.util.Collection;

public class ADCustomUserDetailsContextMapper extends LdapUserDetailsMapper {

    private final UserDetailsService userDetailsService;

    @Autowired
    public ADCustomUserDetailsContextMapper(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx,
                                          String username, Collection<? extends GrantedAuthority> authorities) {
        return userDetailsService.loadUserByUsername(username);
    }
}