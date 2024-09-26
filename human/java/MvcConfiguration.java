import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Import;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.test.smsportal.controller", 
"com.test.smsportal.service", "com.test.smsportal.dao",
"com.test.smsportal.common.filter"})
@Import({CustomWebSecurityConfigurerAdapter.class})
public class MvcConfiguration implements WebMvcConfigurer {
    // something
}