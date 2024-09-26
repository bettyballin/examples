import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig13urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig13 {

    @Configuration
    @Order(1)
    public static class SoapApiConfigurationAdapter extends WebSecurityConfig13urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/soap/**")
                .csrf().disable()
                .httpBasic();
        }
    }

    @Configuration
    public static class WebApiConfigurationAdapter extends WebSecurityConfig13urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .formLogin()
                    .loginProcessingUrl("/authentication")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                    .and()
                .csrf().disable();
        }
    }
}