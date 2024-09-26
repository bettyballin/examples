import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1495 {
    public static void main(String[] args) {
        System.out.println("Security configuration loaded.");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CSRF protection
        http.csrf().disable();

        // Authorization
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated();

        // Login
        http
            .formLogin()
                .loginPage("/login");

        // Logout
        http
            .logout();

        // Access Denied
        http
            .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }
}

class CustomAccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       org.springframework.security.access.AccessDeniedException accessDeniedException)
            throws java.io.IOException, javax.servlet.ServletException {
        response.sendRedirect("/access-denied");
    }
}