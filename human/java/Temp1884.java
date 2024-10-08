import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class Temp1884 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Security configuration class");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // to ignore csrf filter for zookeeper client api
        http.csrf().ignoringAntMatchers("/inner/event/bus");

        // configure the HttpSecurity
        http.antMatcher("/inner/service/**").authorizeRequests()
            // configure open resources. this configuration can be missed because of root level security (see line before)
            .antMatchers("/", "/index.html", "/inner/event/bus", "view.html").permitAll()

            // configure role for specified api
            .antMatchers("/inner/service/**").hasRole("USER")

            // to use default login and logout api
            .and().formLogin().and().logout().logoutSuccessUrl("/").and().httpBasic();
    }
}