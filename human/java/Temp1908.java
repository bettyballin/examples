import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class Temp1908 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp1908 Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/register", "/javax.faces.resource/**").permitAll()
            .antMatchers("/**").authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .usernameParameter("username").passwordParameter("password")
            .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}