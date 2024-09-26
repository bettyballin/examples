import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myDBAuthenticationService);
    }

    @Configuration
    @Order(1)
    public static class WebConfigurationAdapter1 extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/am/**").authorizeRequests().anyRequest().hasRole("AM")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin().loginPage("/amLogin").loginProcessingUrl("/am/postLogin")
                .defaultSuccessUrl("/am/chatPage").failureUrl("/amLogin?error")
                .and().logout().logoutUrl("/am/logout").logoutSuccessUrl("/amLogoutSuccessful")
                .deleteCookies("JSESSIONID")
                .and().csrf().disable();

            System.out.println("1st Configurer");
        }
    }

    @Configuration
    @Order(2)
    public static class WebConfigurationAdapter2 extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("CUSTOMER")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin().loginPage("/customerLogin").loginProcessingUrl("/customer/postLogin")
                .defaultSuccessUrl("/customer/chatPage").failureUrl("/customerLogin?error")
                .and().logout().logoutUrl("/customer/logout").logoutSuccessUrl("/customerLogoutSuccessful")
                .and().csrf().disable();

            System.out.println("2nd Configurer");
        }
    }
}

@Service
class MyDBAuthenticationService implements UserDetailsService {

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your user loading logic here
        // Below is just a dummy user for illustration purposes
        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password("{noop}password") // {noop} means no password encoding
                .roles("USER")
                .build();
    }
}