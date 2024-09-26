import com.github.benmanes.caffeine.cache.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2TokenIntrospectionClient;

import java.util.concurrent.TimeUnit;

@Component
public class CachingOpaqueTokenIntrospector implements OAuth2TokenIntrospectionClient {

    private final LoadingCache<String, IntrospectedToken> cache;

    public CachingOpaqueTokenIntrospector(
            @Qualifier("introspectionUri") String introspectionUri,
            RestTemplate restTemplate)
    {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(30L, TimeUnit.MINUTES)
                .build(CacheLoader.from(token -> {
                    OAuth2AuthenticatedPrincipal principal = restTemplate
                            .postForObject(introspectionUri + "?token=" + token,
                                           null, 
                                           OAuth2AuthenticatedPrincipal.class);

                    return new IntrospectedToken(principal != null ? principal.getAttributes() : null);
                }));
    }

    @Override
    public IntrospectedToken introspect(String token) {
        return cache.get(token);
    }

    public static class IntrospectedToken {
        private final Object attributes;

        public IntrospectedToken(Object attributes) {
            this.attributes = attributes;
        }

        public Object getAttributes() {
            return attributes;
        }
    }
}