import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;

@Controller
public class Temp1019 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot would typically start the application here.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .exceptionHandling()
                .accessDeniedHandler((request, response, e) -> 
                    request.getRequestDispatcher("/getFrontPage.html").forward(request, response));
    }
}