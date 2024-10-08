import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override 
    public void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers().antMatchers("/bookmarks", "/bookmarks/**")    
            .and()
            .authorizeRequests().anyRequest().access("#oauth2.hasScope('write')");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(OAuth2Configuration.RESOURCE_ID);
    }
}