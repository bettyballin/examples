import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Order(1)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/abc/**"))
            .authorizeRequests()
                .antMatchers("/abc/**", "/abc/dfg/**").hasAuthority("ABC")
                .and()
            .csrf().disable()
            .oauth2ResourceServer().jwt();
    }
}

@EnableWebSecurity
@Order(2)
@Configuration
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/actuator/**"))
            .authorizeRequests()
                .antMatchers("/actuator/**").hasRole("ADMIN")
                .and()
            .httpBasic();
    }
}