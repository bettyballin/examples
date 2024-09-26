import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.findByUsername(name);

        if (user == null || !password.equals(user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Check for banned users
        if (isBannedUser(user)) {
            throw new LockedException("This account is locked.");
        }

        List<GrantedAuthority> authorities = getUserAuthorities(user);

        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean isBannedUser(User user) {
        // Check if the user is banned here.
        // For demonstration, let's assume the user has a 'banned' field.
        return user.isBanned();
    }

    private List<GrantedAuthority> getUserAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Assuming user roles are stored in a database or another storage
        // and can be retrieved from a service.
        // For demonstration, let's assume roles are predefined.
        String[] roles = {"ROLE_USER", "ROLE_ADMIN"};

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}

// Assuming a UserService and User class is defined as follows:

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        // Assuming users are stored in a database or another storage
        // and can be retrieved from a repository.
        // For demonstration, let's assume users are predefined.
        User user = new User();
        user.setUsername(username);
        user.setPassword("password");
        user.setBanned(false);

        return user;
    }
}

public interface UserService {
    User findByUsername(String username);
}

import java.util.List;

public class User {
    private String username;
    private String password;
    private boolean banned;
    private List<GrantedAuthority> roles;

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

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }
}