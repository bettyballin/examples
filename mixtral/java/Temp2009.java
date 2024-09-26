import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2009 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is not necessary for the configuration but is required to make this class executable.
        System.out.println("Temp2009 class executed.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .csrf().ignoringAntMatchers("/rest/**");
    }
}