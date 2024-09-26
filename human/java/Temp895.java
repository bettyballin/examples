import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@SpringBootApplication
public class Temp895 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp895.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
              .anyRequest().authenticated()
              .and()
            .formLogin()
              .loginPage("/login")
              .defaultSuccessUrl("/sites")
              .failureUrl("/login")
              .successHandler(yourSuccessHandlerBean())
              .and()
            .logout()
              .permitAll();
    }

    @Bean
    public AuthenticationSuccessHandler yourSuccessHandlerBean() {
        return new SimpleUrlAuthenticationSuccessHandler("/sites");
    }
}