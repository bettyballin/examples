import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.EnableCaching;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("introspectCache");
    }
}

@Component
public class CachingOpaqueTokenIntrospector implements OpaqueTokenIntrospector {

    private final OpaqueTokenIntrospector delegate;
    private final CacheManager cacheManager;

    public CachingOpaqueTokenIntrospector(OpaqueTokenIntrospector delegate, CacheManager cacheManager) {
        this.delegate = delegate;
        this.cacheManager = cacheManager;
    }

    @Override
    public OAuth2IntrospectionAuthenticatedPrincipal introspect(String token) {
        Cache cache = cacheManager.getCache("introspectCache");
        OAuth2IntrospectionAuthenticatedPrincipal principal = cache.get(token, OAuth2IntrospectionAuthenticatedPrincipal.class);
        if (principal == null) {
            principal = delegate.introspect(token);
            cache.put(token, principal);
        }
        return principal;
    }
}