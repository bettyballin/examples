import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1844 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would typically be started here
        // SpringApplication.run(Temp1844.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login.htm*").hasAuthority("ROLE_ANONYMOUS")
                .antMatchers("/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .and()
            .formLogin();
    }
}