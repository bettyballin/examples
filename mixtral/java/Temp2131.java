import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2131 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Security configuration class loaded.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow access to static resources
        http
            .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated() // Restrict all other requests
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll();
    }
}