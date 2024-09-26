import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Register resource handler for CSS and JS files
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        // Other static resources
    }
}