import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.NimbusOpaqueTokenIntrospector;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.ExpiryPolicyBuilder;
import org.ehcache.expiry.Duration;

import java.time.Instant;

public class CustomOpaqueTokenIntrospector implements OpaqueTokenIntrospector {
  private final OpaqueTokenIntrospector introspector;
  private final CacheManager cacheManager;
  private final Cache<String, OAuth2AuthenticatedPrincipal> accessTokens;

  public CustomOpaqueTokenIntrospector(String uri, String clientId, String clientSecret) {
    cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);
    accessTokens = cacheManager.createCache("iamCache",
        CacheConfigurationBuilder
            .newCacheConfigurationBuilder(String.class, OAuth2AuthenticatedPrincipal.class,
                ResourcePoolsBuilder.heap(1000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(1800)))
            .build());

    this.introspector = new NimbusOpaqueTokenIntrospector(uri, clientId, clientSecret);
  }

  @Override
  public OAuth2AuthenticatedPrincipal introspect(String token) {
    OAuth2AuthenticatedPrincipal cached = accessTokens.get(token);
    if (cached != null) {
      Instant exp = (Instant) cached.getAttributes().get("exp");
      if (exp != null && exp.isAfter(Instant.now())) {
        return cached;
      } else {
        accessTokens.remove(token);
      }
    }
    OAuth2AuthenticatedPrincipal principal = introspector.introspect(token);
    accessTokens.put(token, principal);
    return principal;
  }
}