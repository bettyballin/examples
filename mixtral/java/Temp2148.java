import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2148 {
    public static void main(String[] args) {
        System.out.println("This is a Spring Security configuration example.");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
                .antMatchers("/login", "/js/**", "/css/**", "/img/**", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
        // @formatter:on
    }
}