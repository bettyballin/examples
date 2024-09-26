import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp533 {
    public static void main(String[] args) {
        // Your main method logic here
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login")
            .permitAll();

        http.exceptionHandling().authenticationEntryPoint((HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) ->
            request.getRequestDispatcher("/login?error").forward(request, response));
    }
}