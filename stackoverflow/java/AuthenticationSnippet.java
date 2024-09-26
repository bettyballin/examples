import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class AuthenticationSnippet {
    public UsernamePasswordAuthenticationToken createAuthenticationToken(String name, String password, Collection<? extends GrantedAuthority> authorities, User user) {
        return new UsernamePasswordAuthenticationToken(user == null ? new User(name, password, false) : user, password, authorities);
    }
}