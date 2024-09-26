import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@ConditionalOnProperty(name = "my.security.enabled")
@Import(SecurityAutoConfiguration.class)
@EnableWebSecurity
public class MySecurityConfiguration2 extends WebSecurityConfigurerAdapter {
    
}