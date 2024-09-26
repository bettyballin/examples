import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class SoapApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/soap/**")
                .csrf().disable()
                .httpBasic();
        }
    }

    @Configuration
    public static class WebApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http        
                .formLogin()
                    .loginProcessingUrl("/authentication")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password").permitAll()
                    .and()
                .csrf().disable();
        }
    }
}