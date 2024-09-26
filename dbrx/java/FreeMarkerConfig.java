import freemarker.template.Configuration;
import freemarker.ext.jsp.TaglibFactory;
import freemarker.ext.jsp.TaglibFactory.ClasspathMetaInfTldSources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FreeMarkerConfig {

    @Bean
    public freemarker.template.Configuration freeMarkerConfigurer() {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_30);
        // ... other configurations

        try {
            Map<String, Object> sharedVariables = new HashMap<>();
            TaglibFactory.ClasspathMetaInfTldSources jspTaglibFactory = new TaglibFactory.ClasspathMetaInfTldSources(cfg.getTemplateLoader());
            sharedVariables.put("JspTaglibs", jspTaglibFactory);

            cfg.setSharedVariables(sharedVariables);
            // ... other configurations
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cfg;
    }
}