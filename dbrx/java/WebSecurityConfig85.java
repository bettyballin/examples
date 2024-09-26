import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/dashboard").hasAuthority("ADMIN")
            .anyRequest().authenticated();
    }
}

Note that I removed the `SpringSecurityConfiguration` class and the `apply` method call, as `GlobalMethodSecurityConfiguration` is meant to be used as a separate configuration class, not as a nested class. Also, `DefaultWebSecurityExpressionHandler` is the default implementation used by `WebSecurityConfigurerAdapter`, so it's not necessary to specify it explicitly.