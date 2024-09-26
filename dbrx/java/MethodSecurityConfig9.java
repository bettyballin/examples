import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return new CustomAnnotationSecurityMetadataSource();
    }
}

class CustomAnnotationSecurityMetadataSource implements MethodSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> targetClass) {
        // Your custom method security logic here
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Method.class.isAssignableFrom(clazz);
    }
}