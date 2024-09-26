import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        return DefaultUserAuthenticationConverter.INSTANCE.convertUserAuthentication(userAuthentication);
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        return DefaultUserAuthenticationConverter.INSTANCE.extractAuthentication(map);
    }
}