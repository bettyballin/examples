import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig145urerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

public class SecurityConfig145 extends WebSecurityConfig145urerAdapter {

    private AuthenticationSuccessHandler successHandler;
    private AuthenticationFailureHandler failureHandler;
    private LogoutSuccessHandler logoutSuccessHandler;

    public SecurityConfig145(AuthenticationSuccessHandler successHandler,
                          AuthenticationFailureHandler failureHandler,
                          LogoutSuccessHandler logoutSuccessHandler) {
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
            .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
            .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }
}