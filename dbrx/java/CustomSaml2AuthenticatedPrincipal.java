import java.util.Collections;
import java.util.Map;

interface Saml2AuthenticatedPrincipal {
    Map<String, Object> getAttributes();
    String getName();
}

public class CustomSaml2AuthenticatedPrincipal implements Saml2AuthenticatedPrincipal {

    private final String nameId;

    public CustomSaml2AuthenticatedPrincipal(String nameId) {
        this.nameId = nameId;
    }

    @Override
    public Map<String, Object> getAttributes() {
        // Parse the XML response and extract attributes here.
        return Collections.emptyMap();
    }

    @Override
    public String getName() {
        return nameId;
    }

    public static void main(String[] args) {
        CustomSaml2AuthenticatedPrincipal principal = new CustomSaml2AuthenticatedPrincipal("exampleNameId");
        System.out.println("Principal Name: " + principal.getName());
        System.out.println("Principal Attributes: " + principal.getAttributes());
    }
}