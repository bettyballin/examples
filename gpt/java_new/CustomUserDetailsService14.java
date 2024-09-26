import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;

@Service
public class CustomUserDetailsService14 implements UserDetailsService {

    private final LdapTemplate ldapTemplate;

    @Autowired
    public CustomUserDetailsService14(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<String> userMail = ldapTemplate.search(
            query().where("uid").is(username),
            (AttributesMapper<String>) attrs -> (String) attrs.get("mail").get());

        if (userMail.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        // Assuming UserDetailsImpl is an existing implementation of UserDetails
        return new UserDetailsImpl(username, userMail.get(0));
    }
}