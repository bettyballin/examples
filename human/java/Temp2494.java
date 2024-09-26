import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RootDomainInterceptor())
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/webjars/**");
    }

    private static class RootDomainInterceptor extends HandlerInterceptorAdapter {
        // Implement preHandle, postHandle, afterCompletion if needed
    }
}