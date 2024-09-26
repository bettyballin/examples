import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

@Configuration
public class WebConfig {

    @Bean
    public ViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setOrder(1);
        resolver.setMediaTypes(Collections.singletonMap("json", "application/json"));

        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        resolver.setDefaultViews(Collections.singletonList(jsonView));

        resolver.setIgnoreAcceptHeader(true);
        return resolver;
    }
}