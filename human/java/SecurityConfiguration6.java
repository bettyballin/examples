import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.core.userdetails.jdbc.JdbcUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService uds) throws Exception {
        auth
                .userDetailsService(uds)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsManager udm(DataSource dataSource) {
        JdbcUserDetailsManager udm = new JdbcUserDetailsManager();
        udm.setDataSource(dataSource);
        return udm;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

@Service
public class MyUserService {

    @Autowired
    UserDetailsManager udm;

    public void createUser(String username, String password, String... roles) {
        User.UserBuilder builder = User.withUsername(username).password(passwordEncoder().encode(password)).roles(roles);
        udm.createUser(builder.build());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}