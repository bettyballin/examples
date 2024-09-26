import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.http.HttpMethod;

public class Temp1849 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Match POST requests to /api/users
        RequestMatcher postToUsers = new AntPathRequestMatcher("/api/users", HttpMethod.POST.toString());

        http
            .requestMatchers()
                .antMatchers("/api/**")
                    .and()
                        // Permit all POST requests to /api/users
                        .authorizeRequests().requestMatchers(postToUsers).permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application entry point would normally be here
    }
}