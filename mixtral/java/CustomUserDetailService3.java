import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private YourCustomDao dao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
        // Load your custom user object from the database or any other source
        CustomUser user = (CustomUser) this.dao.loadUserByEmail(email);

        if (user == null) throw new UsernameNotFoundException("No such email address: " + email);

        return user;
    }
}

class YourCustomDao {
    // Implement your DAO methods here
    public CustomUser loadUserByEmail(String email) {
        // Dummy implementation for demonstration
        return new CustomUser(email, "password");
    }
}

class CustomUser implements UserDetails {
    private String email;
    private String password;

    public CustomUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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