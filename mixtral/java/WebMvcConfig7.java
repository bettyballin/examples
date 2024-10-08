import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Redirect /foo/* to in_development.html
        registry.addRedirectViewController("/foo/**", "/in_development_page");

        // No need to call super.addViewControllers(registry) as it's not necessary in the WebMvcConfigurer interface
    }
}