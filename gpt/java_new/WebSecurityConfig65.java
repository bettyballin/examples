import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class WebSecurityConfig65 {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // Most restrictive first
            .antMatchers("/admin/employee").hasRole("ADMIN_MANAGER")
            // Then the broader matchers
            .antMatchers("/admin/**").hasAnyRole("ADMIN_STAFF", "ADMIN_MANAGER")
            .antMatchers("/edit-information/**").hasRole("USER")
            .antMatchers("/home").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/home/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/home/login-fail")
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }
}