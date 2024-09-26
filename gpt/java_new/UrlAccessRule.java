import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.List;

@Entity
public class UrlAccessRule {
    @Id
    private Long id;
    private String pattern;
    private String access;

    // Getters and setters
}

interface UrlAccessRuleRepository extends JpaRepository<UrlAccessRule, Long> {
}

class DatabaseSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private final UrlAccessRuleRepository urlAccessRuleRepository;

    public DatabaseSecurityMetadataSource(UrlAccessRuleRepository urlAccessRuleRepository) {
        this.urlAccessRuleRepository = urlAccessRuleRepository;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // Implementation goes here
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // Implementation goes here
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}