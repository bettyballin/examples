import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class Temp1999 {
    private static final String[] ADMIN = {"ROLE_ADMIN"};

    public static void main(String[] args) {
        Temp1999 instance = new Temp1999();
        Collection<? extends GrantedAuthority> authorities = instance.getAuthorities();
        authorities.forEach(authority -> System.out.println(authority.getAuthority()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(ADMIN);
    }
}