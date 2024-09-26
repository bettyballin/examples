import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityConfig57 {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    // Constructor or setter for authenticationSuccessHandler

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/restricted_area/*")
                .access("hasRole('ADMIN')")
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}