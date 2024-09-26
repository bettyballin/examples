import org.springframework.security.access.annotation.AnnotationMetadataExtractor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Collections;

// Assuming a custom Role annotation exists
@interface Role {
    String value();
}

@Component
public class CustomAnnotationSecurityMetadataSource implements AnnotationMetadataExtractor<Role> {

    @Override
    public Collection<ConfigAttribute> extractAttributes(Role role) {
        if (role != null && role.annotationType().getSimpleName().equals(Role.class.getSimpleName())) {
            return Collections.singletonList(new SecurityConfig(role.value()));
        }
        return Collections.emptyList();
    }
}