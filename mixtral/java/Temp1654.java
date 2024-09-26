import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetails myUserDetails;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetails)
            .passwordEncoder(passwordEncoder());
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Your UserDetailsService implementation
    class MyUserDetails implements UserDetailsService {

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // Load your user from the database or any other source
            User user = loadUserFromDataSource(username); // Placeholder for actual user loading logic
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }

            List<GrantedAuthority> authorities = new ArrayList<>();
            if (user.isAdmin()) {
                authorities.add(new SimpleGrantedAuthority("ADMIN"));
            }

            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(user.getEncodedPassword()) // Assuming `user` has a method to get the encoded password
                    .authorities(authorities)
                    .build();
        }

        private User loadUserFromDataSource(String username) {
            // Placeholder method to simulate loading a user from a data source
            // Replace with actual logic to load user from your data source
            return new User(username, "encodedPassword", true); // Example user
        }

    }

    // Placeholder User class for demonstration purposes
    class User {
        private String username;
        private String encodedPassword;
        private boolean admin;

        public User(String username, String encodedPassword, boolean admin) {
            this.username = username;
            this.encodedPassword = encodedPassword;
            this.admin = admin;
        }

        public String getUsername() {
            return username;
        }

        public String getEncodedPassword() {
            return encodedPassword;
        }

        public boolean isAdmin() {
            return admin;
        }
    }
}