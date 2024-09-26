import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

// ... other necessary imports ...

@Service
public class UserDetailsHandler implements UserDetailsService {
    // ... existing code ...

    private UsersService usersService; // Assuming UsersService is injected or initialized somewhere

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = usersService.findByLogin(username);

        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        UserEntity userEntity = userOptional.get();

        // Check if the account is locked
        if (userEntity.isLocked()) { // Assuming UserEntity has a method isLocked()
            throw new LockedException("User account is locked");
        }

        // Assuming UserEntity has methods to get username, password and authorities
        return new User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("USER"))); // Placeholder for actual authorities
    }

    // ... other methods, if any ...
}