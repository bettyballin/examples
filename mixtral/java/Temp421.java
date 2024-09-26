import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp421 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp421 Application Started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/index", "/quizStart").permitAll()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();
    }
}