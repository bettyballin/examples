import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource;

@Configuration
@EnableGlobalMethodSecurity
public class MyMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        // Assuming SecuredAnnotationSecurityMetadataSource is a valid existing class
        // that implements MethodSecurityMetadataSource and has an appropriate constructor
        return new SecuredAnnotationSecurityMetadataSource(...);
    }    
}