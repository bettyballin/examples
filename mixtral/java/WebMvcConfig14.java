import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Serve static files from the /static directory
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        // No need to call super.addResourceHandlers(registry);
    }
}