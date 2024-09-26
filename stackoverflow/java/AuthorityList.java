import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class AuthorityList {
    public static void main(String[] args) {
        Collection<? extends GrantedAuthority> authorities = null; // Placeholder for the actual authorities
        List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        listAuthorities.addAll(authorities);
    }
}