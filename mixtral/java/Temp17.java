import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp17 {

    public static void main(String[] args) {
        // Your main method logic here
    }

    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .successHandler(customAuthenticationSuccessHandler());
        }

        // Create a bean for the custom authentication success handler
        @Bean
        public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
            return new CustomAuthenticationSuccessHandler();
        }
    }

    public static class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
                                            javax.servlet.http.HttpServletResponse response,
                                            org.springframework.security.core.Authentication authentication)
                throws java.io.IOException, javax.servlet.ServletException {
            // Custom logic for successful authentication
            response.sendRedirect("/homepage");
        }
    }
}