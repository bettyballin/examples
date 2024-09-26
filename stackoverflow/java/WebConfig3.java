// Assuming this is part of a Spring configuration class and rootDomainInterceptor() is defined elsewhere in the class or is a bean.
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig3 implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rootDomainInterceptor())
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/webjars/**");
    }

    // Placeholder for the actual interceptor bean
    public Object rootDomainInterceptor() {
        // Implementation or bean retrieval here
        return null;
    }
}