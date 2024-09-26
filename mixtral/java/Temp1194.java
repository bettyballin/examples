import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.dialect.IDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Temp1194 {
    public static void main(String[] args) {
        // Main method content here
    }

    @Bean
    public SpringTemplateEngine templateEngine(
            ITemplateResolver resolver,
            SpringSecurityDialect sec) {
        final SpringTemplateEngine engine = new SpringTemplateEngine();

        // Add the dialects
        List<IDialect> dialList = new ArrayList<>();

        if (sec != null)
            dialList.add(sec);

        engine.setAdditionalDialects(dialList);
        engine.setTemplateResolver(resolver);

        return engine;
    }
}