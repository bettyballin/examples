import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@SpringBootApplication
public class SecurityConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityConfigApplication.class, args);
    }

    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .exceptionHandling()
                .authenticationEntryPoint(forbiddenEntryPoint())
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
            
            http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        }

        @Bean
        public AuthenticationEntryPoint forbiddenEntryPoint() {
            return new Http403ForbiddenEntryPoint();
        }
    }
}