import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Restrict access to all pages except login and error
        http.authorizeRequests()
            .antMatchers("/", "/login*").permitAll()
            .anyRequest().authenticated();

        // Configure form-based authentication
        http
            .formLogin(form -> {
                form
                    .defaultSuccessUrl("/dashboard")
                    .failureHandler((request, response, exception) -> {
                        request.getSession().setAttribute("error", "Invalid username and password.");
                        response.sendRedirect("/login");
                    });
            })
            // Configure logout
            .logout(logout -> {
                logout
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true);
            });
    }
}