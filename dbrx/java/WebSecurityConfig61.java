import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.access.intercept.SecurityMetadataSource;

import javax.servlet.Filter;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                        fsi.setSecurityMetadataSource(new CustomFilterInvocationSecurityMetadataSource());
                        return fsi;
                    }
                })
                // Other configurations
        ;
    }

    private class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

        @Override
        public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
            // Custom logic to determine the required authorities for the specific object (e.g., URL)
            return List.of(new SecurityConfig("ROLE_USER"));
        }

        @Override
        public Collection<ConfigAttribute> getAllConfigAttributes() {
            // Return all the configured security attributes
            return null;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            // Check if the class is supported by this SecurityMetadataSource
            return Filter.class.isAssignableFrom(clazz);
        }
    }
}