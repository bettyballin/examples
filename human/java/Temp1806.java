import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp1806 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().maximumSessions(1)
                .sessionRegistry(sessionRegistry()).expiredUrl("/");
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/security/checkpoint/for/admin/**").hasRole("ADMIN")
                .antMatchers("/rest/users/**").hasRole("ADMIN").anyRequest()
                .authenticated().and().formLogin().loginPage("/")
                .defaultSuccessUrl("/welcome").permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
                .exceptionHandling().accessDeniedPage("/page_403");//this is what you have to do here to get job done.
    }

    private SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public static void main(String[] args) {
        System.out.println("Temp1806 class executed successfully.");
    }
}