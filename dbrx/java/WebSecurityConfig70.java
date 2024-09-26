import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomExpressionHandler expressionHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        for (String pattern : patternsToProtectWithScope("READ_SOMETHING")) {
            registry.antMatchers(pattern).access(expressionHandler.hasOAuth2Scope("READ_SOMETHING"));
        }

        // Other security configurations...
    }

    private List<String> patternsToProtectWithScope(String scope) {
        return Arrays.asList("/type-a");
    }
}

@Component
public class CustomExpressionHandler extends OAuth2WebSecurityExpressionHandler {
    public String hasOAuth2Scope(String scope) {
        return "#oauth2.hasScope('" + scope + "')";
    }
}