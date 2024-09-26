import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3085 extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
        "/v2/api-docs", "/swagger-resources", "/swagger-resources/**",
    };

    public static void main(String[] args) {
        // Spring Boot applications usually don't have a main method like this
        // Instead, you would run the application using Spring Boot's @SpringBootApplication annotation
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/csrf").permitAll()
                .anyRequest().authenticated(); 
    }
}