import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2298 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .anyRequest().authenticated()
                    .and()
                        .formLogin().loginPage("/login")
                             .usernameParameter("emailUser").passwordParameter("passwd")
                             .and()
                             .antMatcher("/secure/rest/**").permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application would normally start here
        // For standalone Java class, main method is not needed for Spring Security configuration
    }
}