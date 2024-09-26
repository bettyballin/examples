import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;

class MyGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_USER";
    }
}

public class UserDetailsImpl2 implements UserDetails {
    private Collection<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        UserDetailsImpl2 u = new UserDetailsImpl2();
        u.getAuthorities().add(new MyGrantedAuthority());
    }
}