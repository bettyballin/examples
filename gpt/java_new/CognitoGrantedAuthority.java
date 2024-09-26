import org.springframework.security.core.GrantedAuthority;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CognitoGrantedAuthority implements GrantedAuthority {
    private final String roleArn;

    public CognitoGrantedAuthority(String roleArn) {
        this.roleArn = roleArn;
    }

    @Override
    public String getAuthority() {
        return roleArn;
    }
}

public class CognitoAuthorityConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> cognitoAttributes = jwt.getClaims();
        List<String> roles = (List<String>) cognitoAttributes.get("cognito:groups");
        return roles.stream()
                .map(CognitoGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}