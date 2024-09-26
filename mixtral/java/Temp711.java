import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class Temp711 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method can be used to run the application if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Admin config
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .and()
                .formLogin()
                    .loginPage("/")
                    .usernameParameter("username")
                    .passwordParameter("password");

        // User config
        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_USER')")
            .and()
                .formLogin();

        // Common login failure and logout configuration
        http
            .formLogin()
                .failureUrl("/")
            .and()
            .logout()
                .logoutSuccessUrl("/");

        // Custom success handler
        http.formLogin().successHandler(new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

                if (roles.contains("ROLE_ADMIN")){
                    getRedirectStrategy().sendRedirect(request, response, "/admin");
                } else {
                    getRedirectStrategy().sendRedirect(request, response, "/user");
                }
            }
        });

        http.csrf().disable();
    }
}