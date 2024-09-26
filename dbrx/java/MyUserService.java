import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class MyUserService {

    @Autowired
    private CustomAuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    public void createUser(String username, String password, String... roles) {
        // Use builder here...
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager(dataSource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authenticationManager.setUserDetailsService(userDetailsService);
        authenticationManager.setPasswordEncoder(encoder);

        User user = User.withUsername(username)
                .password(encoder.encode(password))
                .roles(roles)
                .build();

        userDetailsService.createUser(user);
    }
}