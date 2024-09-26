import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_USER";
    }
}

public class UserDetailsImpl implements UserDetails {
    private Collection<MyGrantedAuthority> authorities = new ArrayList<>();

    @Override
    public Collection<MyGrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getUsername() {
        return "username";
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

    public static void main(String[] args) {
        UserDetailsImpl u = new UserDetailsImpl();
        u.getAuthorities().add(new MyGrantedAuthority());
        for (MyGrantedAuthority authority : u.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }
    }
}