import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2906 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method can be used to start Spring Boot application, if required
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.logout().logoutSuccessUrl("/home")
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasAuthority("ROLE_USER");
    }
}