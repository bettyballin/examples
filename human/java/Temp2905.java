import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2905 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.logout().logoutSuccessUrl("/home")
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasAuthority("user");
    }
}