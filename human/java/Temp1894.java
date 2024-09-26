import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp1894 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1894.class, args);
    }

    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/gpns/rest/gpnfeedback/**").hasRole("CLIENT")
                .antMatchers("/gpns/rest/sendgpn/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        }
    }
}