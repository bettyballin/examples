import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class Temp342 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .anyRequest().authenticated();

        // For API calls return 403 instead of redirecting
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/**")
                .hasAnyRole("USER")
                .and()
            .exceptionHandling().accessDeniedHandler(new ResponseEntityAccessDeniedHandler())
                .and()
            .httpBasic()
                .and()
            .csrf().disable()
            .logout()
                .logoutSuccessUrl("/login");
    }

    private class ResponseEntityAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Temp342.class, args);
    }
}