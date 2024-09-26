import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class YourClass3 {
    private final Collection<GrantedAuthority> authorities;

    public YourClass3(Collection<GrantedAuthority> authorities) {
        List<GrantedAuthority> temp = new ArrayList<>(authorities);
        this.authorities = Collections.unmodifiableList(temp);
    }
}