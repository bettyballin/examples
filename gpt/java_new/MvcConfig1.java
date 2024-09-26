import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfig1urer;

@Configuration
public class MvcConfig1 implements WebMvcConfig1urer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Assuming this is the intended configuration; modify as necessary
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}