import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class Temp2894 extends WebSecurityConfigurerAdapter {

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

    public static void main(String[] args) {
        // Main method content if required
    }
}

class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                                javax.servlet.http.HttpServletResponse response,
                                org.springframework.security.core.Authentication authentication) 
                                throws java.io.IOException, javax.servlet.ServletException {
        // Custom logout success handling logic here
    }
}