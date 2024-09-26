import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tomcat.util.http.LegacyCookieProcessor;

@Configuration
public class Temp3240 {
    public static void main(String[] args) {
        // Main method can be used to run the Spring application
        // This code does not start a Spring Boot application but shows how to create the bean
    }

    @Bean
    public TomcatContextCustomizer cookieProcessorCustomizer() {
        return (context) -> context.setCookieProcessor(new LegacyCookieProcessor());
    }
}