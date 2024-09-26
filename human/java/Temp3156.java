import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3156 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is where the Spring application would typically start
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/employee").hasRole("ADMIN_MANAGER")
            .antMatchers("/admin/**").hasAnyRole("ADMIN_STAFF", "ADMIN_MANAGER")
            .and()
            .formLogin();
    }
}