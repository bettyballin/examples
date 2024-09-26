import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your logic to load user from database using jdbcTemplate
        // Example code
        String sql = "SELECT username, password, enabled FROM users WHERE username = ?";
        UserDetails user = jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
            String uname = rs.getString("username");
            String pwd = rs.getString("password");
            boolean enabled = rs.getBoolean("enabled");
            return org.springframework.security.core.userdetails.User
                    .withUsername(uname)
                    .password(pwd)
                    .disabled(!enabled)
                    .roles("USER") // You can set roles here
                    .build();
        });

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}