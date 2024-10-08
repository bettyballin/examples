import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user@mail.com").password("{noop}pass").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .mvcMatchers("/register", "/login").permitAll()
                .mvcMatchers("/result").hasRole("USER")
            .and()
            .formLogin()
                .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/profile", true)
                    .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}