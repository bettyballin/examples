import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {

    private static final String USERNAME = "username";
    private static final String AUTHORITIES = "authorities";

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        Map<String, Object> response = new HashMap<>();
        response.put(USERNAME, userAuthentication.getName());
        response.put(AUTHORITIES, userAuthentication.getAuthorities().stream()
                .map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList()));
        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME)) {
            Collection<SimpleGrantedAuthority> authorities = ((Collection<String>) map.get(AUTHORITIES)).stream()
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            User user = new User((String) map.get(USERNAME), "N/A", authorities);
            return new UsernamePasswordAuthenticationToken(user, "N/A", authorities);
        }
        return null;
    }
}