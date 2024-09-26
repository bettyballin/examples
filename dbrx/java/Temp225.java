import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp225 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationSuccessHandler customAuthSuccessHandler = new CustomAuthenticationSuccessHandler();

        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login")
                .successHandler(customAuthSuccessHandler)
                // Set default target URL if needed otherwise Spring will redirect to "/"
                //.defaultTargetUrl("/")
            .and()
            .logout()
                .permitAll();
    }
}

class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setTargetUrlFromRequest(request);
        handler.setDefaultTargetUrl("/"); // Default target URL
        handler.onAuthenticationSuccess(request, response, authentication);
    }
}