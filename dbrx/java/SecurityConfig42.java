import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public WebXmlMergedFilter webXmlMergedFilter() {
        return new WebXmlMergedFilter("classpath:weblogic-web-security-constraints.xml");
    }
}

class WebXmlMergedFilter {
    private String path;

    public WebXmlMergedFilter(String path) {
        this.path = path;
    }
}