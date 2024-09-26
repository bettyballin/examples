import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2892 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot application entry point can be added here if required
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/welcome","/inventory/**","/sales/**").access("hasRole('USER')")
            .and().exceptionHandling()
                .accessDeniedPage("/403")
            .and().formLogin()
            .and().logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
            .and()
                .csrf()
                .disable();
    }
}