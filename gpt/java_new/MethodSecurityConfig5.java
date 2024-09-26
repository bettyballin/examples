import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig5uration;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig5 extends GlobalMethodSecurityConfig5uration {

    private final OAuth2SecurityConfiguration oAuth2SecurityConfiguration;

    @Autowired
    public MethodSecurityConfig5(OAuth2SecurityConfiguration oAuth2SecurityConfiguration) {
        this.oAuth2SecurityConfiguration = oAuth2SecurityConfiguration;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return oAuth2SecurityConfiguration.oauth2WebSecurityExpressionHandler();
    }
}

@Configuration
public class OAuth2SecurityConfiguration {

    @Bean
    public OAuth2WebSecurityExpressionHandler oauth2WebSecurityExpressionHandler() {
        return new OAuth2WebSecurityExpressionHandler();
    }
}