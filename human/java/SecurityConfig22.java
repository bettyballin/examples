import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class FrontEndSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        @Qualifier("frontend")
        private UserDetailsService frontendUserDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(frontendUserDetailsService)
                    .passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/frontend/**")
                .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")
                    .and()
                .formLogin();
        }
    }

    @Configuration
    @Order(2)
    public static class BackendSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        @Qualifier("management")
        private UserDetailsService managementUserDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(managementUserDetailsService)
                    .passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/manage/**")
                .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")
                    .and()
                .formLogin();
        }
    }
}