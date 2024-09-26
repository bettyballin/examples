import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temp2395 {

    private static final UserDetails IMPERSONATED_USER = new User("username", "", Collections.singletonList(new SimpleGrantedAuthority("ROLE_IMPERSONATE")));

    public static void main(String[] args) {
        // Add actual logic to run your application here
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager() {
        DefaultOAuth2AuthorizedClientManager manager = new DefaultOAuth2AuthorizedClientManager();

        // Set the custom user details service
        CustomUserDetailsService userDetailsService = new CustomUserDetailsService(IMPERSONATED_USER);

        OAuth2AuthorizationContext authorizationContext = (context) -> {
            context.setPrincipal(userDetailsService.loadUserByUsername("username"));

            // Set the scope for this request
            if (!CollectionUtils.isEmpty(context.getClientRegistration().getScopes())) {
                context.setAuthorizationGrantType(OAuth2AuthorizationContext.AuthorizationGrantType.CLIENT_CREDENTIALS);
                return;
            }

            // Set the scope to default
            List<String> scopes = new ArrayList<>();

            if (context.getClientRegistration().isScoped()) {
                context.setScope(scopes);
                return;
            }

        };

        manager.setAuthorizationContextProvider((authorizationRequest) -> authorizationContext);

        return manager;
    }

    // Assume User and CustomUserDetailsService classes are defined elsewhere
    private static class User implements UserDetails {
        private final String username;
        private final String password;
        private final List<SimpleGrantedAuthority> authorities;

        public User(String username, String password, List<SimpleGrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        @Override
        public List<SimpleGrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

    private static class CustomUserDetailsService {
        private final UserDetails user;

        public CustomUserDetailsService(UserDetails user) {
            this.user = user;
        }

        public UserDetails loadUserByUsername(String username) {
            return user;
        }
    }
}