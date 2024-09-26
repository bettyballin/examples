import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.saml2.provider.service.authentication.OpenSaml4AuthenticationProvider;
import org.opensaml.saml.saml2.core.Assertion;

import java.util.List;
import java.util.stream.Collectors;

public class CustomSaml2AuthenticatedPrincipal extends OpenSaml4AuthenticationProvider.Saml2AuthenticatedPrincipal {

    public CustomSaml2AuthenticatedPrincipal(Assertion assertion) {
        super(assertion);

        // Extract the groups attribute from the Assertion and convert it to authorities.
        List<String> groupAttributes = getAttributeValues("groups");
        if (groupAttributes != null && !groupAttributes.isEmpty()) {
            setAuthorities(groupAttributes.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList()));
        }
    }
}