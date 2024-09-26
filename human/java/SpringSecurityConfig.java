import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private AdminCustomAuthenticationProvider adminCustomAuthenticationProvider;

    @Autowired
    private UserCustomAuthenticationProvider userCustomAuthenticationProvider;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(adminCustomAuthenticationProvider);
        auth.authenticationProvider(userCustomAuthenticationProvider);
    }

    @Bean
    public MyAuthenticationFilter myAuthenticationFilter() throws Exception {
        MyAuthenticationFilter authenticationFilter = new MyAuthenticationFilter();

        authenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());

        return authenticationFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .addFilterBefore(myAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/resources/**", "/", "/login")
            .permitAll()
            .antMatchers("/config/*", "/app/admin/*")
            .hasRole("ADMIN")
            .antMatchers("/app/user/*")
            .hasAnyRole("ADMIN", "USER")
            .antMatchers("/api/**")
            .hasRole("APIUSER")
            .and().exceptionHandling()
            .accessDeniedPage("/403")
            .and().logout()
            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
            .invalidateHttpSession(true);

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }
}

// Custom classes for the handlers and filters

class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

}

class AdminCustomAuthenticationProvider extends org.springframework.security.authentication.dao.DaoAuthenticationProvider {

}

class UserCustomAuthenticationProvider extends org.springframework.security.authentication.dao.DaoAuthenticationProvider {

}

class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Authentication authentication) throws java.io.IOException, javax.servlet.ServletException {
        // Custom logic for successful authentication
    }
}

class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException exception) throws java.io.IOException, javax.servlet.ServletException {
        // Custom logic for failed authentication
    }
}

class CustomLogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Authentication authentication) throws java.io.IOException, javax.servlet.ServletException {
        // Custom logic for successful logout
    }
}