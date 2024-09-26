import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeLeafConfig {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        final SpringResourceTemplateResolver resolver =
                new SpringResourceTemplateResolver();

        // Set the prefix and suffix for your templates
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");

        return resolver;
    }

}