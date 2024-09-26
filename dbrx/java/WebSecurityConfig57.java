import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @PostConstruct
    public void init() {
        try {
            configure(HttpSecurity.httpSecurity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .httpBasic();
    }
}