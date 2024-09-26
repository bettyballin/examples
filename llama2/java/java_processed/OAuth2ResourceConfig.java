import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.authentication.AuthenticationManager;
import javax.annotation.Resource;

@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private DefaultTokenServices tokenServices;

    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("oauth2-endpoints").tokenServices(tokenServices);
    }
}