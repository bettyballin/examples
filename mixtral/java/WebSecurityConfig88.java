import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .successHandler(new CustomAuthSuccessHandler())
                .and()
            .httpBasic();
    }

    private static class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(
                javax.servlet.http.HttpServletRequest request,
                javax.servlet.http.HttpServletResponse response,
                org.springframework.security.core.Authentication authentication) 
                throws java.io.IOException, javax.servlet.ServletException {
            // Custom logic here
        }
    }
}