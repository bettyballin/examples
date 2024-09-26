import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp2088 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity             
              .authorizeRequests()
                 .antMatchers("/")
                     .permitAll()
                 .anyRequest()
                     .authenticated()
                 .and()
              .formLogin()
                 .loginPage("/login")
                 .permitAll()
                 .and()
              .logout()
                 .permitAll()
        ;
    }
}