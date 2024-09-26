import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2429 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/person", true)
                .failureUrl("/login?error")
                .and()
            .authorizeRequests()
                .antMatchers("/**")
                .access("hasRole('ANONYMOUS') or hasRole('USER') and isAnonymous()");
    }
}