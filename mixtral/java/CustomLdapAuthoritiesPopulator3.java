import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.authentication.BadCredentialsException;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
        List<String> groupMemberships = new ArrayList<>();

        try {
            NamingEnumeration<?> ne = userData.getAttributes().get("memberOf").getAll();
            while (ne.hasMoreElements()) {
                String group = (String) ne.nextElement();
                groupMemberships.add(group);
            }
        } catch (NamingException e) {
            throw new BadCredentialsException("Failed to retrieve group memberships", e);
        }

        if (!groupMemberships.contains("AD-this-is-a-specific-group")) {
            throw new BadCredentialsException("User is not part of the required AD Group");
        }

        return AuthorityUtils.createAuthorityList(groupMemberships.toArray(new String[0]));
    }
}