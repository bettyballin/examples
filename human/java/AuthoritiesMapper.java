import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class AuthoritiesMapper implements GrantedAuthoritiesMapper {

    public enum Roles implements GrantedAuthority {
        INVENTADMIN("inventadmin"),
        INVENTUSER("inventuser");

        private final String role;

        Roles(String role) {
            this.role = role;
        }

        @Override
        public String getAuthority() {
            return role;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Set<Roles> roles = EnumSet.noneOf(Roles.class);

        for (GrantedAuthority a : authorities) {
            if ("inventadmin".equals(a.getAuthority())) {
                roles.add(Roles.INVENTADMIN);
            } else if ("inventuser".equals(a.getAuthority())) {
                roles.add(Roles.INVENTUSER);
            }
        }
        return roles;
    }

    public static void main(String[] args) {
        AuthoritiesMapper mapper = new AuthoritiesMapper();
        Collection<GrantedAuthority> inputAuthorities = Set.of(new SimpleGrantedAuthority("inventadmin"), new SimpleGrantedAuthority("inventuser"));
        Collection<? extends GrantedAuthority> mappedAuthorities = mapper.mapAuthorities(inputAuthorities);

        for (GrantedAuthority authority : mappedAuthorities) {
            System.out.println(authority.getAuthority());
        }
    }
}