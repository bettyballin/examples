import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration2 {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService uds) throws Exception {
        auth
            .userDetailsService(uds)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);
        return userDetailsManager;
    }
}

@Service
public class MyUserService {

    private final UserDetailsManager userDetailsManager;

    @Autowired
    public MyUserService(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    public void createUser(String username, String password, String... authorities) {
        User user = User.withUsername(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .authorities(authorities)
                .build();
        userDetailsManager.createUser(user);
    }
}