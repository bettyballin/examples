import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your existing configuration
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();

        PasswordEncoder passwordEncoder = new StandardPasswordEncoder();

        userDetailsService.setDataSource(dataSource);

        userDetailsService.setPasswordEncoder(passwordEncoder);

        userDetailsService.setEnableGroups(true);

        userDetailsService.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");

        userDetailsService.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");

        return new ProviderManager(Arrays.<AuthenticationProvider>asList(new DaoAuthenticationProvider() {
            {
                setUserDetailsService(userDetailsService);
                setPasswordEncoder(passwordEncoder);
            }
        }));
    }

}