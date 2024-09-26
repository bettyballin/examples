import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2317 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/customer/**").authorizeRequests().anyRequest().authenticated().and().authorizeRequests().anyRequest().hasRole("USER")
            .and()
            .formLogin()
            .loginPage("/customerLogin")
            .loginProcessingUrl("/customer/postLogin")
            .defaultSuccessUrl("/customer/home")
            .failureUrl("/customerLogin?error")
            .and()
            .logout().logoutUrl("/customer/logout").logoutSuccessUrl("/home")
            .and()
            .csrf().disable();
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp2317.class, args);
    }
}


Make sure to include the necessary Spring Boot dependencies in your `pom.xml` or `build.gradle` file to run this example.