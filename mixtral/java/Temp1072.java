import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp1072 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1072.class, args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    // permit all GET and POST requests to "/", "/home"
                    .antMatchers(HttpMethod.GET, "/", "/home").permitAll()
                    .antMatchers(HttpMethod.POST, "/", "/home").permitAll()
                    // allow DELETE request only with authentication
                    .antMatchers(HttpMethod.DELETE).authenticated()
                    // any other requests require authentication
                    .anyRequest().authenticated();
        }
    }
}