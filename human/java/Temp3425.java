import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

@EnableWebSecurity
public class Temp3425 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your application logic here, if any
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/ws/persons/createNotificationsSubscriber*").permitAll() // --> This will work
            .antMatchers(HttpMethod.POST, "/ws/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/**").authenticated()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers(HttpMethod.GET, "/ws/getEvents").permitAll() // ---> While this is working
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("http://localhost:3006/eventsMainView")
            .and()
            .httpBasic();
    }
}