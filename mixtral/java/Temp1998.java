import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class Temp1998 {
    private static final String[] USER = {"USER"};

    public static void main(String[] args) {
        Temp1998 instance = new Temp1998();
        Collection<? extends GrantedAuthority> authorities = instance.getAuthorities();
        authorities.forEach(auth -> System.out.println(auth.getAuthority()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(USER);
    }
}