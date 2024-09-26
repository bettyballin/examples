import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.time.Duration;
import java.time.Instant;

public class CustomOpaqueTokenIntrospector implements OpaqueTokenIntrospector {
    private final OpaqueTokenIntrospector introspector;
    private CacheManager cacheManager;
    private Cache<String, OAuth2AuthenticatedPrincipal> accessTokens;

    public CustomOpaqueTokenIntrospector(String uri, String clientId, String clientSecret) {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        accessTokens = cacheManager.createCache("iamCache",
                CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String.class, OAuth2AuthenticatedPrincipal.class,
                                ResourcePoolsBuilder.heap(1000))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(1800))));

        this.introspector = new NimbusOpaqueTokenIntrospector(uri, clientId, clientSecret);
    }

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        if (this.accessTokens.containsKey(token)) {
            if (this.getAccessTokensCacheFromCacheManager().get(token).getAttribute("exp") != null
                    && ((Instant) this.getAccessTokensCacheFromCacheManager().get(token).getAttribute("exp"))
                    .isAfter(Instant.now())) {
                return this.getAccessTokensCacheFromCacheManager().get(token);
            }

            this.getAccessTokensCacheFromCacheManager().remove(token);
        }
        OAuth2AuthenticatedPrincipal principal = introspector.introspect(token);
        this.getAccessTokensCacheFromCacheManager().put(token, principal);

        return principal;
    }

    public Cache<String, OAuth2AuthenticatedPrincipal> getAccessTokensCacheFromCacheManager() {
        return cacheManager.getCache("iamCache", String.class, OAuth2AuthenticatedPrincipal.class);
    }
}