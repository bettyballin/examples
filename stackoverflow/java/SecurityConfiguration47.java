import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration47 {

    @Configuration
    @Order(1)
    public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/v1/users/**")
                .authorizeRequests().anyRequest()
                .hasRole("USER").and().httpBasic();
        }
    }

    @Configuration
    @Order(2)
    public static class MVCSecurityConfiguration47 extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers("/resources/**", "/users/register", "/users/signup", "/users/confirm",
                            "/users/user-action", "/users/reset-password", "/confirm", "/webjars/**").permitAll()
                    .antMatchers("/users/**").hasRole("USER")
                    .and()
                    .formLogin().usernameParameter("username").passwordParameter("password");
        }
    }
}