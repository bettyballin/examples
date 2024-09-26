import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        mappings.add("json", "application/json;charset=utf-8");
        mappings.add("pdf", "application/pdf");
        factory.setMimeMappings(mappings);
    }
}

@Configuration
public class AppMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**", "/css/**", "/img/**", "/js/**", "/pdf/**")
                .addResourceLocations("classpath:/assets/", "classpath:/css/", "classpath:/img/", "classpath:/js/", "classpath:/pdf/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}