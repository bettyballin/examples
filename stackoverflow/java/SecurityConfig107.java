import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig107urerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class SecurityConfig107 extends WebSecurityConfig107urerAdapter {

    private static class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
        // Implement necessary methods for LogoutSuccessHandler
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/", "/login", "/api/**")
                    .permitAll()
                .antMatchers("/app/admin/*")
                    .hasRole("ADMIN")
                .antMatchers("/app/user/*")
                    .hasAnyRole("ADMIN", "USER")
            .and().exceptionHandling().accessDeniedPage("/403")
            .and().formLogin()
                .loginPage("/login").usernameParameter("userName")
                .passwordParameter("password")
                .defaultSuccessUrl("/app/user/dashboard")
                .failureUrl("/login?error=true")
            .and().logout()
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .invalidateHttpSession(true)
            .and().csrf().disable();

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }
}