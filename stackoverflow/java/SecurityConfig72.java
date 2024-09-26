import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfig72urer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class SecurityConfig72 extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "my-resource-name";

    @Override
    public void configure(ResourceServerSecurityConfig72urer resources) {
        resources.resourceId(RESOURCE_ID);
    }
}