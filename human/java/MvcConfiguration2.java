import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.test.smsportal.controller",
    "com.test.smsportal.service",
    "com.test.smsportal.dao",
    "com.test.smsportal.common.filter",
    "com.test.smsportal.configuration"
})
public class MvcConfiguration implements WebMvcConfigurer {
    // Implement necessary methods or leave it empty if not needed
}