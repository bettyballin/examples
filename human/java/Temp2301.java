import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2301 {
    public static void main(String[] args) {
        System.out.println("Application running...");
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/userReged/**").hasRole("USER")
                .and()
            .formLogin()
                .loginPage("/")
                .defaultSuccessURL("/somePage")
                .failureURL("/user/logfailed?error")
                .usernameParameter("userName")
                .passwordParameter("userPassword")
                .and()
            .logout()
                .logoutSuccessURL("/?logout");
    }
}