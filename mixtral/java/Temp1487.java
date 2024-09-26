import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import java.util.*;

@SpringBootApplication
public class Temp1487 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1487.class, args);
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();

        // Map Keycloak role names to Spring Security GrantedAuthority
        Set<String> rolesToGrantedAuthoritiesMapping = new HashSet<>();

        for (Role role : Role.values()) {
            String authorityPrefix = "ROLE_";
            if (!role.name().startsWith(authorityPrefix))
                throw new IllegalArgumentException("Invalid role name: " + role);

            rolesToGrantedAuthoritiesMapping.add(role.name());
        }

        converter.setUserTokenConverter(authentication -> {
            Map<String, ?> map = authentication.getOAuth2Request().getRequestParameters();
            Set<String> authorities = new HashSet<>((Collection<? extends String>) map.get("authorities"));

            if (authorities == null || authorities.isEmpty())
                return Collections.emptyList();

            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            for (String authority : rolesToGrantedAuthoritiesMapping) {
                if (authorities.contains(authority)) {
                    grantedAuths.add(() -> authority);
                }
            }

            return grantedAuths;
        });

        return converter;
    }

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }
}