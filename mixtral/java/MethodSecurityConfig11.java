import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return new CustomRoleAnnotationMetadataExtractor();
    }
    
}

class CustomRoleAnnotationMetadataExtractor implements MethodSecurityMetadataSource {
    // Implementation of the CustomRoleAnnotationMetadataExtractor

    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> targetClass) {
        // Implementation logic
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> targetClass, Object target) {
        // Implementation logic
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // Implementation logic
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // Implementation logic
        return true;
    }
}