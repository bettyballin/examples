import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.AnnotationMetadataExtractor;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.prepost.PrePostAnnotationSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Collections;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
    String value();
}

public class RoleAnnotationMetadataExtractor implements AnnotationMetadataExtractor<Role> {
    @Override
    public Collection<? extends ConfigAttribute> extractAttributes(Role securityAnnotation) {
        return Collections.singletonList(new SecurityConfig(securityAnnotation.value()));
    }
}

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
        return expressionHandler;
    }

    private class CustomPermissionEvaluator implements PermissionEvaluator {
        @Override
        public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
            // Implement your permission logic here
            return true; // For the sake of this example, we just return true
        }

        @Override
        public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
            // Implement your permission logic here
            return true; // For the sake of this example, we just return true
        }
    }
}