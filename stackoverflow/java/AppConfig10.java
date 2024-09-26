import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class AppConfig10 implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ServiceKeyValidator())
                .addPathPatterns("/ifttt/**")
                .excludePathPatterns("/actuator/**");
    }

    // Assuming ServiceKeyValidator is a defined Interceptor
    // If not, it should be created as a separate class
    class ServiceKeyValidator implements org.springframework.web.servlet.HandlerInterceptor {
        // Implement required methods for HandlerInterceptor interface
    }
}