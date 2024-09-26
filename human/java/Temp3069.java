import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp3069Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp3069Application.class, args);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/", "index", "login", "/resource/**").permitAll()
                        .antMatchers("/userpage").hasRole("USER")
                        .and()
                        .formLogin()
                        .loginPage("/myLoginPage") // Pointing to the controller method
                        .loginProcessingUrl("/authenticateTheUser") // No coding is needed. Spring will automatically handle this.
                        .defaultSuccessUrl("/myFirstPage", true)
                        .permitAll()
                        .and()
                        .logout()
                        .permitAll();
            }
        };
    }
}