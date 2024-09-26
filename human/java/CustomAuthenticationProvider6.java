import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        User user = userService.getUserWithPermissionsByName(username);
        if (user == null) {
            throw new BadCredentialsException("invalid_username_or_pass");
        }

        if (!passwordService.passwordsMatch(password, user.getPassword())) {
            throw new BadCredentialsException("invalid_username_or_pass");
        }

        String[] permissions = user.getPermissions().stream().map((p) -> p.getName()).toArray(String[]::new);
        List<GrantedAuthority> grantedAuths = AuthorityUtils.createAuthorityList(permissions);
        return new UsernamePasswordAuthenticationToken(new LoggedInUser(user.getName(), user.getPassword(), true, true, true, true, grantedAuths, user.getId()),
                password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}

// Assuming the existence of the following classes and interfaces
class User {
    private String name;
    private String password;
    private List<Permission> permissions;
    private Long id;

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public Long getId() {
        return id;
    }
}

class Permission {
    private String name;

    // Getters and setters

    public String getName() {
        return name;
    }
}

class LoggedInUser extends org.springframework.security.core.userdetails.User {
    private Long userId;

    public LoggedInUser(String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        List<GrantedAuthority> authorities, Long userId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

interface UserService {
    User getUserWithPermissionsByName(String username);
}

interface PasswordService {
    boolean passwordsMatch(String rawPassword, String encodedPassword);
}