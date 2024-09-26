import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepo.findByUserName(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user.get();
    }
}

interface UserRepo {
    Optional<User> findByUserName(String username);
}

class User implements UserDetails {
    // Implement UserDetails methods here

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return authorities
        return null;
    }

    @Override
    public String getPassword() {
        // return password
        return null;
    }

    @Override
    public String getUsername() {
        // return username
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // return account non expired status
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // return account non locked status
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // return credentials non expired status
        return false;
    }

    @Override
    public boolean isEnabled() {
        // return enabled status
        return false;
    }
}