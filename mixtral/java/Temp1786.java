import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Temp1786 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }

    // Or in case of Java configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Your other configurations
            .authorizeRequests()
                // Your authorization configurations
                .anyRequest().authenticated()
            .and()
            .authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailService);
        return authProvider;
    }

    public static void main(String[] args) {
        // Your main method implementation
    }
}