import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl {

    public User createUser(DomainUser domainUser) {
        boolean enabled = false; 
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getId())
        );
    }

    private List<GrantedAuthority> getAuthorities(int roleId) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        if (roleId == 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (roleId == 2) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        
        return authorities;
    }

    static class DomainUser {
        private String login;
        private String password;
        private Role role;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }
    }

    static class Role {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        DomainUser domainUser = new DomainUser();
        domainUser.setLogin("testUser");
        domainUser.setPassword("testPassword");
        Role role = new Role();
        role.setId(1);
        domainUser.setRole(role);

        UserDetailsServiceImpl service = new UserDetailsServiceImpl();
        User user = service.createUser(domainUser);
        System.out.println("User created: " + user.getUsername() + ", Enabled: " + user.isEnabled());
    }
}