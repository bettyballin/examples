import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/admin/**")
            .authorizeRequests()
                .anyRequest().hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login-process")
                .defaultSuccessUrl("/admin/home")
                .and()
            .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login");
    }
}

@Configuration
@Order(2)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/user/**")
            .authorizeRequests()
                .anyRequest().hasRole("USER")
                .and()
            .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login-process")
                .defaultSuccessUrl("/user/home")
                .and()
            .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/login");
    }
}