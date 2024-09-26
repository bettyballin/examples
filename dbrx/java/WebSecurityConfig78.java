import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.SecurityExpressionOperations;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler() {
            @Override
            protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, org.springframework.security.core.context.SecurityContext context) {
                WebSecurityExpressionRoot root = (WebSecurityExpressionRoot) super.createSecurityExpressionRoot(authentication, context);
                root.setDefaultRolePrefix(""); // Remove the default ROLE_ prefix
                return new CustomExpressionRoot(authentication, context);
            }
        };

        http.authorizeRequests()
                .expressionHandler(expressionHandler)
                .antMatchers("/type-a").access("@customExpressionRoot.hasOAuth2Scope('READ_SOMETHING')")
                .anyRequest().hasRole("USER")
                .and().httpBasic();
    }

    public class CustomExpressionRoot extends WebSecurityExpressionRoot {
        private String scope;

        public CustomExpressionRoot(Authentication authentication, org.springframework.security.core.context.SecurityContext context) {
            super(authentication, context);
        }

        public boolean hasOAuth2Scope(String scope) {
            this.scope = scope;
            return true; // or false based on your logic
        }
    }
}