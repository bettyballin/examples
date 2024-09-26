import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.opensaml.saml1.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.schema.XSString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.AuthenticationException;

public class CustomSamlCredentialMapper implements CredentialMapper {

    @Override
    public Set<GrantedAuthority> getRoles(Assertion assertion) throws AuthenticationException {
        final List<String> roles = new ArrayList<>();

        if (assertion != null && assertion.getAttributeStatements() != null
                && !assertion.getAttributeStatements().isEmpty()) {
            for (AttributeStatement attributeStatement : assertion.getAttributeStatements()) {

                final List<Attribute> attributes = attributeStatement.getAttributes();

                if (!attributes.isEmpty()) {
                    for (final Attribute attr : attributes) {

                        // Check the name of your group attribute here
                        if ("groups".equals(attr.getName())) {

                            final List<XMLObject> values = attr.getAttributeValues();

                            for (final XMLObject value : values) {

                                XSString xsStringAttr = (XSString) value;

                                // Convert the group name to a role string
                                final String roleName = "ROLE_" + xsStringAttr.getValue();

                                roles.add(roleName);

                            }

                        }

                    }

                }

            }

        }

        return new HashSet<>(roles
                .stream()
                // Convert the role strings to GrantedAuthority objects
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));

    }

}