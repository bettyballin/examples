import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class Temp1226 {
    public static void main(String[] args) {
        Temp1226 temp = new Temp1226();
        Collection<? extends GrantedAuthority> authorities = temp.getAuthorities();
        authorities.forEach(authority -> System.out.println(authority.getAuthority()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] permissions = {"ROLE_USER", "ROLE_ADMIN"}; // Example permissions
        return AuthorityUtils.createAuthorityList(permissions);
    }
}