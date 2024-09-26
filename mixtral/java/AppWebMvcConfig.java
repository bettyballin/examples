import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private DarngoodAuthenticationProvider darnGoodAuth;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(darnGoodAuth);
    }
}

// You will also need DarngoodAuthenticationProvider class to make it fully executable.
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class DarngoodAuthenticationProvider implements HandlerInterceptor {
    // Implement the methods of HandlerInterceptor as needed
}