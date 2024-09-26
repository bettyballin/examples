import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@SpringBootApplication
public class Temp1398 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1398.class, args);
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/imgs/**").permitAll()
                .antMatchers(HttpMethod.POST, "/updatepass**").permitAll()
                .anyRequest().fullyAuthenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();
    }
}