import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecureConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add secure configuration here
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .permitAll()
            .and()
            .httpBasic();
    }
}

@Order(99)
@Configuration
public class AppUnsecuredConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void setManagement() {
        // Add unsecured configuration here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/management/**")
            .authorizeRequests()
                .anyRequest().permitAll();
    }
}