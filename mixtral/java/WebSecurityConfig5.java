import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;

    @Order(1)
    public static class AMWebSecurityAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .mvcMatchers("/am/**")
                        .access("hasRole('ROLE_AM')")
                .and()
                .formLogin()
                    .loginPage("/amLogin")
                    .loginProcessingUrl("/am/postLogin");
        }
    }

    @Order(2)
    public static class CustomerWebSecurityAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .mvcMatchers("/customer/**")
                        .access("hasRole('ROLE_CUSTOMER')")
                .and()
                .formLogin()
                    .loginPage("/customerLogin")
                    .loginProcessingUrl("/customer/postLogin");
        }
    }
}