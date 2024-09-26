import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class YourUserDetailService implements UserDetailsService {

    private final YourRepository repository;

    @Autowired
    public YourUserDetailService(YourRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        YourUser yourUser = repository.findByUsername(username);
        if (yourUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(yourUser.getUsername())
                .password(yourUser.getPassword())
                .roles(yourUser.getRoles())
                .build();
    }
}

// Assuming YourRepository and YourUser are defined as follows

interface YourRepository {
    YourUser findByUsername(String username);
}

class YourUser {
    private String username;
    private String password;
    private String[] roles;

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

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}