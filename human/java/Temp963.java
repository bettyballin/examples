import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class Temp963 {
    public static void main(String[] args) {
        // Normally Spring Boot application would start here, but this is a placeholder
        System.out.println("Spring Security configuration loaded.");
    }

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/welcome").hasRole("ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessURL("/welcome")
                    .failureURL("/loginfailed")
                    .and()
                .logout()
                    .logoutSuccessURL("/logout");
        }

        @Bean
        @Override
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withDefaultPasswordEncoder().username("test").password("123456").roles("ADMIN").build());
            return manager;
        }
    }
}