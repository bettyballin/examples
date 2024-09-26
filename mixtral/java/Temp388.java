import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp388 extends WebSecurityConfigurerAdapter {

    @Autowired
    public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure your AuthenticationManagerBuilder here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomMethodSecurityExpressionHandler handler = new CustomMethodSecurityExpressionHandler();

        // @formatter:off
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
                = http.authorizeRequests();

        handler.setDefaultRolePrefix("");

        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler
                = new DefaultWebSecurityExpressionHandler();

        // Assuming you have an authentication object and request object
        // You should replace these with actual instances in a real application
        Object authentication = null; // Replace with actual authentication object
        Object request = null; // Replace with actual request object

        WebSecurityExpressionRoot root = (WebSecurityExpressionRoot)
                defaultWebSecurityExpressionHandler.createEvaluationContext(authentication, request).getRootObject();

        registry
                .access("@root.checkAccountId(#accountId)");
    }

    // You need to define this class or import it from the appropriate package
    static class CustomMethodSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
        // Implement your custom logic here
    }
}