import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.Arrays;

public class Temp541 extends WebSecurityConfigurerAdapter {

    private static final String[] endpointsToSecure = {"/secure-endpoint1", "/secure-endpoint2"};

    public static void main(String[] args) {
        // This main method is present just to make the class executable,
        // The actual Spring Security configuration will be handled by Spring Boot's auto-configuration.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] ipWhitelist = {"192.168.1.100", "10.0.0.2"}; // Add the IP addresses to whitelist

        http.authorizeRequests()
                .requestMatchers(endpointsToSecure).access(getAccessExpression(ipWhitelist))
                .and()
                // Other configurations
                ;
    }

    private String getAccessExpression(String[] ipWhitelist) {
        StringBuilder accessExpression = new StringBuilder();
        for (int i = 0; i < ipWhitelist.length; i++) {
            accessExpression.append("hasIpAddress('").append(ipWhitelist[i]).append("')");
            if (i < ipWhitelist.length - 1) {
                accessExpression.append(" or ");
            }
        }
        accessExpression.append(" or isAuthenticated()");
        return accessExpression.toString();
    }
}