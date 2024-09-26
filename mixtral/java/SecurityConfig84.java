import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserService;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .userInfoEndpoint(userInfoEndpoint ->
                        userInfoEndpoint
                            .userAuthoritiesMapper(new CognitoRoleToSpringSecurityAuthorityConverter())
                    )
            );
    }

    private static class CognitoRoleToSpringSecurityAuthorityConverter implements OAuth2UserService<OidcUserRequest, OAuth2User> {
        private final OidcUserService delegate = new OidcUserService();

        @Override
        public OAuth2User loadUser(OidcUserRequest userRequest) {
            OAuth2User oidcUser = delegate.loadUser(userRequest);
            Map<String, Object> attributes = oidcUser.getAttributes();
            Collection<? extends GrantedAuthority> authorities = oidcUser.getAuthorities();
            Set<GrantedAuthority> mappedAuthorities = authorities.stream()
                .map(authority -> {
                    if (authority instanceof OAuth2UserAuthority) {
                        Map<String, Object> claims = ((OAuth2UserAuthority) authority).getAttributes();
                        return claims.entrySet().stream()
                            .filter(entry -> entry.getKey().equals("cognito:groups"))
                            .flatMap(entry -> ((Collection<String>) entry.getValue()).stream())
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                            .collect(Collectors.toSet());
                    }
                    return Set.of(authority);
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
            return new DefaultOAuth2User(mappedAuthorities, attributes, "sub");
        }
    }
}