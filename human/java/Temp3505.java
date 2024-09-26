import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.core.annotation.Order;

@Configuration
@EnableWebSecurity(debug = true)
@Order(1)
class OpenConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
                .antMatchers("/*", "/locales", "/avatars", "robots.txt")
                .and()
            .authorizeRequests()
                .anyRequest()
                .permitAll();
    }

}

@Configuration
@EnableWebSecurity
@Order(2)
class RestrictedConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
                .antMatchers("/api/**")
                .and()
            .authorizeRequests()
                // more fine-grained control within matched group of requests here
                .anyRequest()
                .authenticated()
                .and()
            .httpBasic();
    }
}

@Configuration
@EnableWebSecurity
@Order(3)
class CatchAllConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest()
            .denyAll();
    }

}