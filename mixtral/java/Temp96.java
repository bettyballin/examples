import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@EnableWebSecurity
public class Temp96 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .logout()
                .logoutSuccessHandler(yourCustomLogoutSuccessHandler())
                .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }

    private LogoutSuccessHandler yourCustomLogoutSuccessHandler() {
        return (request, response, authentication) -> {
            // Custom logout logic here
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().flush();
        };
    }

    public static void main(String[] args) {
        // Spring Boot application would be executed here in a real-world scenario
        // For example, SpringApplication.run(Temp96.class, args);
    }
}