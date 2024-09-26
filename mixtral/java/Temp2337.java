import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

public class Temp2337 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application, if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
                .and()
            .csrf().disable()
                .authorizeRequests()
                    // More specific antMatchers first
                    .antMatchers("/ws/getEvents").hasRole("USER")
                    .antMatchers(HttpMethod.POST, "/ws/**").authenticated()
                    .antMatchers(HttpMethod.DELETE, "/**").authenticated()
                    // This should be before anyRequest().authenticated();
                    .antMatchers("/ws/persons/createNotificationsSubscriber*").permitAll()
                .anyRequest().authenticated();
    }
}