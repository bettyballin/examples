import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig196urerAdapter;

public class SecurityConfig196 extends WebSecurityConfig196urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers(HttpMethod.POST, "/ws/persons/createNotificationsSubscriber*").permitAll()
            .antMatchers(HttpMethod.GET, "/ws/getEvents").permitAll()
            .antMatchers(HttpMethod.POST, "/ws/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/**").authenticated()
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("http://localhost:3006/eventsMainView")
            .and()
            .httpBasic();
    }
}