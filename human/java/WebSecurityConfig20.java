import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().enableSessionUrlRewriting(false);

        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                    .permitAll()
            .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/report/**").hasRole("REPORT")
                    .anyRequest().fullyAuthenticated()
            .and().exceptionHandling().accessDeniedPage("/error/403");

    }

    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER").and()
                .withUser("admin").password("{noop}admin").roles("ADMIN","REPORT");
    }
}