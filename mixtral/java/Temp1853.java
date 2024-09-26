import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1853 extends WebSecurityConfigurerAdapter {

    private static final String REALM = "MY_REALM";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/v1/notification").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .realmName(REALM)
                .and()
                .csrf().disable();
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and won't start the application.
        // Typically, a Spring Boot application would be started with SpringApplication.run().
        System.out.println("Application configured");
    }
}