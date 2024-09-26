import org.springframework.security.saml2.provider.service.authentication.OpenSaml4AuthenticationProvider;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.security.saml2.core.OpenSaml4AuthenticationProvider.OpenSaml4AuthenticationException;
import org.opensaml.saml.saml2.core.Assertion;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSaml2AuthenticationProvider extends OpenSaml4AuthenticationProvider {

    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    @Override
    protected Saml2AuthenticatedPrincipal createAuthenticationDetails(RelyingPartyRegistration relyingParty, Assertion assertion) throws OpenSaml4AuthenticationException {
        return new CustomSaml2AuthenticatedPrincipal(assertion);
    }

    public static class CustomSaml2AuthenticatedPrincipal implements Saml2AuthenticatedPrincipal {

        private final Assertion assertion;

        public CustomSaml2AuthenticatedPrincipal(Assertion assertion) {
            Assert.notNull(assertion, "assertion cannot be null");
            this.assertion = assertion;
        }

        @Override
        public String getName() {
            return assertion.getSubject().getNameID().getValue();
        }

        @Override
        public Map<String, List<Object>> getAttributes() {
            Map<String, List<Object>> attributes = new HashMap<>();
            assertion.getAttributeStatements().forEach(statement -> {
                statement.getAttributes().forEach(attribute -> {
                    List<Object> values = new ArrayList<>();
                    attribute.getAttributeValues().forEach(value -> values.add(value.getDOM().getTextContent()));
                    attributes.put(attribute.getName(), values);
                });
            });
            return attributes;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return authorities;
        }
    }
}