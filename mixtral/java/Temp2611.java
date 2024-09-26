import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityConfigurerAdapter;

@SpringBootApplication
public class Temp2611 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2611.class, args);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
            web
                .ignoring().antMatchers("/login", "/logout");
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .cors().and()
                // other configurations...
                .authorizeRequests()
                .anyRequest().authenticated();
        }
    }
}