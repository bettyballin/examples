import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class Temp3106 {
    public static void main(String[] args) {
        // Mock user details for demonstration
        String username = "user1";
        String encodedPwd = "encodedPassword";
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        // Assuming a dataSource object is already configured
        javax.sql.DataSource dataSource = null; // Placeholder for actual DataSource configuration

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.createUser(
            User.withUsername(username)
                .password(encodedPwd)
                .authorities(authorities)
                .disabled(false)
                .build()
        );
    }
}