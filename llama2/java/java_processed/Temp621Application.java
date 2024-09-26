import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.AuthorizationManager;
import org.springframework.security.web.access.intercept.DefaultAuthorizationManager;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Temp621Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp621Application.class, args);
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            AuthorizationManager authorizationManager = new DefaultAuthorizationManager();
            // Assuming CustomPermissionEvaluator is defined elsewhere in your project
            // authorizationManager.setPermissionEvaluator(new CustomPermissionEvaluator());

            http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/something").authenticated()
                .or()
                .hasIpAddress("172.17.0.0/24");
        }
    }
}