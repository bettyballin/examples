import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig6urerAdapter;

@Configuration
public class WebSecurityConfig6 {

    @Configuration
    @Order(1)                                                        
    public static class RestWebSecurityConfig6urationAdapter extends WebSecurityConfig6urerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/**").authenticated()
            .and()
                .httpBasic()
            .and()
                .csrf().disable();    
        }
    }
}