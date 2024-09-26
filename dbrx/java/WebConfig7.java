import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Add other view controllers

        registry.addViewController("/error_400").setViewName("forward:/error");
        registry.addViewController("/error_404").setViewName("forward:/error");
    }
}