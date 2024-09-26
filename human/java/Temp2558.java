import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Temp2558 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2558.class, args);
    }
    
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/index").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/index").hasRole("USER")
                .and()
                .csrf().disable();
        }
    }
}