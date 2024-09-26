import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ImportResource({ "/WEB-INF/spring-security.xml", "/WEB-INF/spring-webflow.xml" })
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // ...

}