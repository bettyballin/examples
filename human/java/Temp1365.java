import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp1365Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp1365Application.class, args);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                    .authorizeRequests()
                    .antMatchers("/non-secure/**").permitAll()
                    .antMatchers("/secure/**").hasAuthority("user")
                    .and().requiresChannel().antMatchers("/non-secure/**").requiresInsecure()
                    .and().requiresChannel().antMatchers("/secure/**").requiresSecure();
            }
        };
    }
}