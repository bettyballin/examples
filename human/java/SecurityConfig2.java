import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new LoginAuthenticationSuccessHandler(this.userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .successHandler(successHandler())
                .and()
            .httpBasic();
    }
}

class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserDetailsService userDetailsService;

    public LoginAuthenticationSuccessHandler(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void onAuthenticationSuccess(
        javax.servlet.http.HttpServletRequest request, 
        javax.servlet.http.HttpServletResponse response, 
        org.springframework.security.core.Authentication authentication
    ) throws java.io.IOException, javax.servlet.ServletException {
        // Custom logic here
    }
}