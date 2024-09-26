import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private static final long serialVersionUID = 1L;
    private SecurityUser securityUser;

    public CurrentUser(SecurityUser securityUser) {
        super(securityUser.getUsername(), securityUser.getPassword(), AuthorityUtils.createAuthorityList(securityUser.getRole().toString()));
        this.securityUser = securityUser;
    }

    public SecurityUser getSecurityUser() {
        return securityUser;
    }

    public String getRole() {
        return securityUser.getRole();
    }
}

class SecurityUser {
    private String username;
    private String password;
    private String role;

    public SecurityUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}