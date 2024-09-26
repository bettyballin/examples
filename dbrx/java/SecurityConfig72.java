import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.List;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "module.client.security.enabled")
public class SecurityConfig {

    @Value("${management.endpoints.web.base-path}")
    private String managementEndpoint;

    @Autowired
    private List<ModuleProperties> moduleProperties;

    @Configuration
    public static class GlobalAnonymousAuthentication extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/**").anonymous();
        }
    }

    @Configuration
    public static class CustomFilterConfig extends WebSecurityConfigurerAdapter {

        private final ClientResolveFilter clientResolveFilter;

        @Autowired
        public CustomFilterConfig(ClientResolveFilter clientResolveFilter) {
            this.clientResolveFilter = clientResolveFilter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.requestMatchers()
                    .antMatchers("/app/**")
                    .and()
                    .addFilterBefore(clientResolveFilter, FilterSecurityInterceptor.class);
        }
    }
}