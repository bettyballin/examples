import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableWebMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}

@Configuration
@EnableWebMvc
class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IFTTTServiceKeyInterceptor());
    }
}

@Component
class IFTTTServiceKeyInterceptor extends HandlerInterceptorAdapter {
    private static final String YOUR_VALID_SERVICE_KEY = "your-valid-service-key"; // Replace with your actual service key

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String serviceKeyHeader = request.getHeader("IFTTT-Service-Key");

        if (serviceKeyHeader == null || !serviceKeyHeader.equals(YOUR_VALID_SERVICE_KEY)) {
            throw new UnauthorizedException("Invalid IFTTT-Service-Key header");
        }

        return super.preHandle(request, response, handler);
    }
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}