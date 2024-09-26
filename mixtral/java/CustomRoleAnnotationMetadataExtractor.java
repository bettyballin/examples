import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

public class CustomRoleAnnotationMetadataExtractor implements MethodSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> targetClass) {
        Role role = AnnotationUtils.findAnnotation(method, Role.class);

        if (role != null && !StringUtils.isEmpty(role.value())) {
            return Collections.singletonList(() -> "ROLE_" + role.value());
        }

        return Collections.emptyList(); // Return empty collection or default attributes
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

// Dummy Role annotation for the sake of compiling the code
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Role {
    String value();
}