import org.springframework.security.core.authority.AuthorityUtils;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class AuthorityListExample {
    public static void main(String[] args) {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        // Use the authorities list as needed...
    }
}