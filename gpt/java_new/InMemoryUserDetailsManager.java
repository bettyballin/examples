import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class InMemoryUserDetailsManager implements UserDetailsService {

    private Map<String, UserDetails> users = new HashMap<>();
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public InMemoryUserDetailsManager() {
        users.put("user", org.springframework.security.core.userdetails.User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .authorities("ROLE_USER")
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        return user;
    }
}