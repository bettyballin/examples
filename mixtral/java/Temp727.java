import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

public class Temp727 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        String[] whiteListedIps = {"192.0.2.0", "198.51.100.0"};

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
                = http.authorizeRequests();

        for (String ip : whiteListedIps) {
            // Allow access to specific endpoint from the whitelisted IP without authentication
            registry
                    .antMatchers(HttpMethod.POST, "/examplePattern")
                    .access("hasIpAddress('" + ip + "')");
        }

        http
                .authorizeRequests()
                // ... other configurations
                .anyRequest().authenticated(); // Example configuration to secure all other endpoints
    }

    public static void main(String[] args) {
        // Spring Boot would usually be used to run this, so main method is not typically needed here.
    }
}