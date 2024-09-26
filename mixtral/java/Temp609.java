import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.core.userdetails.jdbc.JdbcUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import javax.sql.DataSource;

@SpringBootApplication
public class Temp609 {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Temp609.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsService(DataSource dataSource, PasswordEncoder enc) throws Exception {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);

        if (!manager.userExists("admin")) {
            User admin = userBuilder()
                    .username("admin")
                    .passwordEncoder(enc::encode)
                    .roles("USER", "ADMIN").build();
            manager.createUser(admin);
        }

        if (!manager.userExists("user")) {
            User user = userBuilder()
                    .username("user")
                    .passwordEncoder(enc::encode)
                    .roles("USER").build();
            manager.createUser(user);
        }

        return manager;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig, UserDetailsManager userDetailsService) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return authConfig.getAuthenticationManager();
    }

    private UserBuilder userBuilder() {
        return User.builder();
    }
}