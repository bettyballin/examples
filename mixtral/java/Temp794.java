import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp794 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/index**").permitAll()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin(); // Add your form login configuration here

        http.csrf().disable();
    }

    public static void main(String[] args) {
        // Spring Boot application should be started here, 
        // typically using SpringApplication.run(Application.class, args);
    }
}