import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OAuth2AuthenticationExample {

    public static void main(String[] args) {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();

        LinkedHashMap linkedHashMap = (LinkedHashMap) oAuth2Authentication.getUserAuthentication().getDetails();

        Set<GrantedAuthority> authorities =
                ((List<GrantedAuthority>) oAuth2Authentication.getAuthorities()).stream()
                        .collect(Collectors.toCollection(() -> EnumSet.noneOf(SimpleGrantedAuthority.class)));

        User user = new User(); // Assuming you have a User class with setAuthorities method
        user.setAuthorities(authorities);

        // Additional logic as needed
    }
}

class User {
    private Set<GrantedAuthority> authorities;

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}