import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;

import java.util.Collection;

public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // Call the default implementation of DefaultOAuth2UserService to get the OAuth2User object.
        OAuth2User oauth2User = new DefaultOAuth2UserService().loadUser(userRequest);

        Collection<? extends GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN_USER, ROLE_OFFICE_USER");

        return new CustomOAuth2AuthenticationToken(oauth2User, authorities);
    }

    public static class CustomOAuth2AuthenticationToken implements OAuth2User {
        private final OAuth2User oauth2User;
        private final Collection<? extends GrantedAuthority> authorities;

        public CustomOAuth2AuthenticationToken(OAuth2User oauth2User, Collection<? extends GrantedAuthority> authorities) {
            this.oauth2User = oauth2User;
            this.authorities = authorities;
        }

        @Override
        public Map<String, Object> getAttributes() {
            return oauth2User.getAttributes();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getName() {
            return oauth2User.getName();
        }
    }
}