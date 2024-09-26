import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

@Configuration
@Profile("test")
public class FreeMarkerTestConfiguration {

    @Bean
    public FreeMarkerConfigurer freemarkerConfigurer() throws IOException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setPreferFileSystemAccess(false);
        configurer.setDefaultEncoding("UTF-8");
        configurer.setTemplateLoaderPaths("classpath:/templates/");
        return configurer;
    }
}