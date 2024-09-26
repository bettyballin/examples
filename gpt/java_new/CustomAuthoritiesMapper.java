import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthoritiesMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomAuthoritiesMapper implements GrantedAuthoritiesMapper {

    @Override
    public Collection<GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        // Assuming you have a way to extract the groups from the SAML assertion (dummy implementation)
        List<String> groupNames = extractGroupNamesFromSamlAssertion();

        return groupNames.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private List<String> extractGroupNamesFromSamlAssertion() {
        // Dummy implementation
        return List.of("ROLE_USER", "ROLE_ADMIN");
    }
}