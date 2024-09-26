import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CognitoRoleToSpringSecurityAuthorityConverter implements GrantedAuthoritiesMapper {

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        List<GrantedAuthority> mappedRoles = new ArrayList<>();

        for (GrantedAuthority authority : authorities) {
            if ("cognito:roles".equalsIgnoreCase(authority.getAuthority())) {
                // Assuming the role is a comma-separated string
                String[] rolesArray = authority.getAuthority().split(",");

                for (String role : rolesArray) {
                    mappedRoles.add(new SimpleGrantedAuthority("ROLE_" + role));
                }
            }
        }

        return mappedRoles;
    }

    public static void main(String[] args) {
        // Example usage
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("cognito:roles=ROLE_ADMIN,ROLE_USER"));

        CognitoRoleToSpringSecurityAuthorityConverter converter = new CognitoRoleToSpringSecurityAuthorityConverter();
        Collection<? extends GrantedAuthority> mappedAuthorities = converter.mapAuthorities(authorities);

        for (GrantedAuthority authority : mappedAuthorities) {
            System.out.println(authority.getAuthority());
        }
    }
}