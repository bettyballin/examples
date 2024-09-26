import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1106 {
    public static void main(String[] args) {
        System.out.println("Application Started");
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .formLogin()
                .and()
                .authorizeRequests()
                    .antMatchers("/index").permitAll() // Add here to allow unauthenticated access
                    .antMatchers("/resources/**").permitAll()
                    .anyRequest().hasRole("USER");
        }
    }
}