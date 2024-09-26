import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class XUserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configure HttpSecurity here
        http.authorizeRequests()
            .antMatchers("/xuser/**").authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManagerBuilder here
        auth.inMemoryAuthentication()
            .withUser("xuser").password("{noop}password").roles("XUSER");
    }
}

@Order(1)
@Configuration
class SecurityConfigX implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // register view controllers
        registry.addRedirectViewController("/login", "/welcome");
    }
}

// Repeat this pattern for other types of users

@Configuration
public class YUserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configure HttpSecurity here
        http.authorizeRequests()
            .antMatchers("/yuser/**").authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManagerBuilder here
        auth.inMemoryAuthentication()
            .withUser("yuser").password("{noop}password").roles("YUSER");
    }
}

@Order(2)
@Configuration
class SecurityConfigY implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // register view controllers
        registry.addRedirectViewController("/login", "/welcome");
    }
}