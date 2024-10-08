import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth
            .inMemoryAuthentication()
                .passwordEncoder(encoder)
                    .withUser("admin")
                      .password(encoder.encode("admin"))
                       .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // HTTP Basic authentication
            .httpBasic()
                .and()
            .authorizeRequests()
            // Anyone can access the urls
            .antMatchers("/", "/home").permitAll()
            // The rest of our application is protected
            .anyRequest().authenticated();
    }
}