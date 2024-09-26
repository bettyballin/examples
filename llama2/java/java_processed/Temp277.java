import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp277 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Application entry point
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();

        http
            .formLogin()
                .successHandler(new RoleBasedLoginSuccessHandler());
    }

    private class RoleBasedLoginSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, 
                                            HttpServletResponse response, 
                                            org.springframework.security.core.Authentication authentication) 
                                            throws IOException, ServletException {
            // Handle successful authentication
        }
    }
}