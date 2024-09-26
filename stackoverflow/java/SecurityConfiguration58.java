import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

public class SecurityConfiguration58 {

    private HttpSecurity http;

    public void configure() throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .expressionHandler(webExpressionHandler());
    }

    private DefaultWebSecurityExpressionHandler webExpressionHandler() {
        return new DefaultWebSecurityExpressionHandler();
    }
}