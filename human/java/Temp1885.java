import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1885 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method can be used to run the application if necessary
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/inner/event/bus");
        http.antMatcher("/inner/service/**").authorizeRequests()
            .antMatchers("/inner/service/**").hasRole("USER")
            .and().formLogin().and().logout().logoutSuccessUrl("/").and().httpBasic();
    }
}