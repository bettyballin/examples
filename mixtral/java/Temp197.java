import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp197 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .rememberMe()
                .tokenValiditySeconds(86400)
                .key("myAppKey")
                .alwaysRemember(true)
                .useSecureCookie(true); // Assuming this is what you meant by saveOnRedirect
    }

    public static void main(String[] args) {
        // This main method is not typically used in Spring applications.
        // Spring Boot application would typically be started with SpringApplication.run(MyApplication.class, args);
    }
}