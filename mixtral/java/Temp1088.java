import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gigsterous.auth.domain.User user = userRepository.findOneByUsername(username);

        if (user == null) throw new UsernameNotFoundException("No such user");

        return new CustomUser(user);
    }
}

// Assuming a UserRepository interface
interface UserRepository {
    com.gigsterous.auth.domain.User findOneByUsername(String username);
}

// Assuming a CustomUser class that implements UserDetails
class CustomUser implements UserDetails {
    private final com.gigsterous.auth.domain.User user;

    public CustomUser(com.gigsterous.auth.domain.User user) {
        this.user = user;
    }

    // Implement necessary methods from UserDetails interface

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement logic to return authorities
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement logic
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement logic
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement logic
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement logic
        return true;
    }
}

// Assuming a User class
package com.gigsterous.auth.domain;

public class User {
    private String username;
    private String password;

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}