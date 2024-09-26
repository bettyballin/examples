import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class Temp984 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method can be used to run the Spring application if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... other configurations

        http
            .sessionManagement()
                .maximumSessions(1)
                    .expiredUrl("/login?expired")
                    .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}