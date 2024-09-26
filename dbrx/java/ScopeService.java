import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

// Dummy ScopeRepository class
class ScopeRepository {
    public List<Segment> getSegments() {
        // Return dummy segments for illustration
        return List.of(new Segment("Segment1"), new Segment("Segment2"));
    }
}

// Dummy Segment class
class Segment {
    private String name;

    public Segment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Dummy BcmsSecurityService class with canAccessSegment method
class BcmsSecurityService {
    public boolean canAccessSegment(Principal principal, Segment segment) {
        // For demonstration purposes, let's allow access to all segments
        return true;
    }
}

// Custom cache key generator
@Configuration
class CacheConfig {
    @Bean
    public KeyGenerator customCacheKeyGenerator() {
        return (target, method, params) -> {
            Principal principal = (Principal) params[0];
            return principal.getName();
        };
    }
}

@Service
public class ScopeService {
    private final ScopeRepository scopeRepository;
    private final BcmsSecurityService bcmsSecurityService;

    public ScopeService(final ScopeRepository scopeRepository, BcmsSecurityService bcmsSecurityService) {
        this.scopeRepository = scopeRepository;
        this.bcmsSecurityService = bcmsSecurityService;
    }

    @PostFilter(value = "@bcmsSecurityService.canAccessSegment(principal, filterObject)")
    @Cacheable(value = "bcmsSegments", keyGenerator = "customCacheKeyGenerator")
    public List<Segment> getSegments(Principal principal) {
        return scopeRepository.getSegments();
    }

    public static void main(String[] args) {
        ScopeRepository scopeRepository = new ScopeRepository();
        BcmsSecurityService bcmsSecurityService = new BcmsSecurityService();
        ScopeService scopeService = new ScopeService(scopeRepository, bcmsSecurityService);

        Principal principal = new User("user", "password", List.of());
        SecurityContextHolder.getContext().setAuthentication(principal);
        List<Segment> segments = scopeService.getSegments(principal);

        segments.forEach(segment -> System.out.println(segment.getName()));
    }
}