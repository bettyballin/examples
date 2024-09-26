import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.util.List;

class CustomAuthHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException exception) throws IOException, javax.servlet.ServletException {
        super.onAuthenticationFailure(request, response, exception);
        // Implement your custom logic here
    }
}

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomAuthHandler customAuthenticationHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthHandler authenticationHandler() {
        return new CustomAuthHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> userRoles = List.of("ROLE_USER", "ROLE_ADMIN");

        String[] rolesArray = userRoles.toArray(new String[0]);

        http.authorizeRequests()
                .antMatchers("/edu/**/Login**/UserSignUP/organization**/email_availablity").permitAll()
                .anyRequest().hasAnyAuthority(rolesArray)
                .and()
                .formLogin()
                .loginPage("/Login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index1", true)
                .failureHandler(customAuthenticationHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}