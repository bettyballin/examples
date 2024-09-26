import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1220 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot applications typically use SpringApplication.run to start
        // SpringApplication.run(Temp1220.class, args);
        System.out.println("Application is running");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/img/**", "/js/**").permitAll()
                .anyRequest().authenticated();
    }
}