import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my-static-content/**")
                .addResourceLocations("classpath:/static/my-static-content/");
    }

    @Override
    public void configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void configureContentNegotiation(org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void configureAsyncSupport(org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        // No implementation needed
    }

    @Override
    public void addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
        // No implementation needed
    }

    @Override
    public void configureViewResolvers(org.springframework.web.servlet.config.annotation.ViewResolverRegistry registry) {
        // No implementation needed
    }

    @Override
    public void addArgumentResolvers(org.springframework.web.servlet.config.annotation.ArgumentResolverConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void addReturnValueHandlers(org.springframework.web.servlet.config.annotation.ReturnValueHandlerConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void configureHandlerExceptionResolvers(org.springframework.web.servlet.config.annotation.HandlerExceptionResolverConfigurer configurer) {
        // No implementation needed
    }

    @Override
    public void configure(org.springframework.web.servlet.config.annotation.WebMvcConfigurer superConfigurer) {
        // No implementation needed
    }

    @Override
    public void configureMessageConverters(org.springframework.web.servlet.config.annotation.MessageConverterConfigurer configurer) {
        // No implementation needed
    }
}