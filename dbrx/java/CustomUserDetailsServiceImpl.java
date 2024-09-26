import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.security.Principal;
import java.security.acl.Group;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Get the WebLogic Role Mapper instance.
        RoleMapper roleMapper;
        try {
            roleMapper = (RoleMapper) InitialContext.doLookup("weblogic.management.security.role.RoleMapper");
        } catch (NamingException e) {
            throw new UsernameNotFoundException("Role Mapper lookup failed for " + username, e);
        }

        // Map users and groups into roles that are recognized by your application.
        Set<GrantedAuthority> userRoles = new HashSet<>();
        try {
            Enumeration<Principal> principals = roleMapper.getPrincipalsForUser(username);
            while (principals.hasMoreElements()) {
                Principal principal = principals.nextElement();
                if (principal instanceof Group) {
                    String groupName = ((Group) principal).getName();
                    // Add the group name to userRoles.
                    userRoles.add(new SimpleGrantedAuthority(groupName));
                }
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error while mapping roles for " + username, e);
        }

        return new User(username, "", userRoles);
    }
}

// Dummy RoleMapper interface to make the code executable
interface RoleMapper {
    Enumeration<Principal> getPrincipalsForUser(String username) throws Exception;
}