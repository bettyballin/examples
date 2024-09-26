import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientIpResolver clientIpResolver;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        // Allow /health for specific clients.
        registry.requestMatchers(new RequestHeaderRequestMatcher("Host", "clientA:8080"))
                .access("@clientIpResolver.resolve(request) != null");

        // Require JWT authentication for other requests from clientB.
        registry.antMatchers("/api/**").authenticated();
    }
}

// Assuming ClientIpResolver is a valid Spring bean.
public class ClientIpResolver {
    public String resolve(javax.servlet.http.HttpServletRequest request) {
        // Implement the logic to resolve the client IP address.
        return "resolvedIpAddress";
    }
}