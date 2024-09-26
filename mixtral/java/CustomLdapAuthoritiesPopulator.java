import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {
        List<String> roleNames = new ArrayList<>();
        Attribute attribute;

        try {
            attribute = ctx.getAttributes().get("memberOf");

            if (attribute != null) {
                NamingEnumeration<?> values = ((BasicAttribute) attribute).getAll();
                while (values.hasMoreElements()) {
                    roleNames.add(((String) values.nextElement()).split(",")[0].substring("CN=".length()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String roleName : roleNames) {
            authorities.add(new SimpleGrantedAuthority(roleName));
        }

        return authorities;
    }
}