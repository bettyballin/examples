import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.AbstractFallbackMethodSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
public class CustomMethodSecurityMetadataSource extends AbstractFallbackMethodSecurityMetadataSource {

    @Override
    protected Collection<ConfigAttribute> findAttributes(Method method, Class<?> targetClass) {
        // Handle custom annotation here
        SecuredAdmin securedAdmin = AnnotationUtils.findAnnotation(method, SecuredAdmin.class);
        
        if (securedAdmin != null) {
            return Collections.singletonList(new SecurityConfig(securedAdmin.value()));
        }
        
        return null;
    }

    @Override
    protected Collection<ConfigAttribute> findAttributes(Class<?> clazz) {
        // Not used in this example
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // Return all possible config attributes here e.g.
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");

        return Collections.singletonList(new SecurityConfig(roles.toArray(new String[0])));
    }
}

// Dummy annotation for demonstration purposes
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SecuredAdmin {
    String value();
}