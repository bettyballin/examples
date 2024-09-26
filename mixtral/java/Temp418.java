import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp418 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Execution starts here if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and().authorizeRequests().antMatchers("/manage/**").hasRole("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and().logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .invalidateHttpSession(true)
            .and().sessionManagement().invalidSessionUrl("/login").maximumSessions(1).expiredUrl("/login");
    }
}