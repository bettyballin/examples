import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    public void configureViewResolvers(ViewResolverRegistry registry) {}

    // Add an interceptor to check if the user is authenticated before accessing any page
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePatterns = new ArrayList<>();

        AuthenticationTrustResolver trustResolver = this.authenticationTrustResolver;

        // Add the welcome URL to be excluded from authentication check
        if (trustResolver != null && !excludePatterns.contains("/welcome")) {
            excludePatterns.add("/welcome");

            registry.addInterceptor(new AuthenticationCheckingInterceptor())
                    .addPathPatterns("/**")
                    .excludePathPatterns(excludePatterns);
        }
    }
}

// Dummy AuthenticationTrustResolver class for demonstration purposes
class AuthenticationTrustResolver {}

// Dummy AuthenticationCheckingInterceptor class for demonstration purposes
class AuthenticationCheckingInterceptor implements org.springframework.web.servlet.HandlerInterceptor {}