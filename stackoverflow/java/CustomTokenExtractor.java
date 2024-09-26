import org.springframework.security.oauth2.provider.token.TokenExtractor;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

public class CustomTokenExtractor implements TokenExtractor {
    @Override
    public Authentication extract(HttpServletRequest request) {
        // Your implementation here
        return null;
    }
}

public class MyResourceServerConfigurerAdapter { // or extend a proper adapter if you're using Spring

    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenExtractor(new CustomTokenExtractor());
    }
}