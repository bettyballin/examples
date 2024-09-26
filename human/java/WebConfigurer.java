import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfigurer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    /**
     * Set up Mime types.
     */
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        // IE issue, see https://github.com/jhipster/generator-jhipster/pull/711
        mappings.add("html", "text/html;charset=utf-8");
        // CloudFoundry issue, see https://github.com/cloudfoundry/gorouter/issues/64
        mappings.add("json", "text/html;charset=utf-8");

        mappings.add("pdf", "application/pdf");

        factory.setMimeMappings(mappings);
    }
}

// Register static resources
@Configuration
public class AppMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Including all static resources.

        registry.addResourceHandler("/assets/**",
                "/css/**",
                "/img/**",
                "/js/**",
                "/pdf/**")
                .addResourceLocations("/assets/",
                        "/css/",
                        "/img/",
                        "/js/",
                        "/pdf/**")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}