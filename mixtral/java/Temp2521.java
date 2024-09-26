import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class Temp2521 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is for demonstration purposes and does nothing in this context.
        System.out.println("WebSecurityConfigurerAdapter example.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .httpBasic().disable(); // Disable basic auth

        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
    }
}