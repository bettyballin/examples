import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public interface MyUserDetails {
    Collection<? extends GrantedAuthority> getAuthorities();
}