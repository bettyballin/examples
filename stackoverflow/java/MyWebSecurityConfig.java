import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('admin') and hasIpAddress('127.0.0.1')")
                .antMatchers("/admin/**").access("hasRole('admin') and hasIpAddress('192.168.1.0/24')")
                .antMatchers("/admin/**").access("hasRole('admin') and hasIpAddress('::1')")
            .and()
            .formLogin().and()
            .httpBasic();
    }
}