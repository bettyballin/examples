import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Temp1803 extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceImpl userDetailServiceImpl;
    private final CustomAuthProvider customAuthProvider;
    private final PasswordService passwordService;

    public Temp1803(UserDetailServiceImpl userDetailServiceImpl, CustomAuthProvider customAuthProvider, PasswordService passwordService) {
        this.userDetailServiceImpl = userDetailServiceImpl;
        this.customAuthProvider = customAuthProvider;
        this.passwordService = passwordService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailServiceImpl).passwordEncoder(passwordService.getPasswordEncoder())
            .and()
            .authenticationProvider(customAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

// Dummy implementations for the missing classes to make the code executable
class UserDetailServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        return org.springframework.security.core.userdetails.User.withUsername("user").password("password").roles("USER").build();
    }
}

class CustomAuthProvider implements org.springframework.security.authentication.AuthenticationProvider {
    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        return null; // Placeholder implementation
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false; // Placeholder implementation
    }
}

class PasswordService {
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}