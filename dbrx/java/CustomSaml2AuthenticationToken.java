import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomSaml2AuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal;
    private final String xmlResponse;

    public CustomSaml2AuthenticationToken(Object principal, String xmlResponse) {
        super(null);
        this.principal = principal;
        this.xmlResponse = xmlResponse;
        setAuthenticated(true); // You might want to manage this differently depending on your use case
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return null; // or return an appropriate credential object
    }

    // Add getters and setters for the XML response
    public String getXmlResponse() {
        return xmlResponse;
    }

    public static void main(String[] args) {
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        User principal = new User("username", "password", authorities);
        String xmlResponse = "<xml>response</xml>";
        
        CustomSaml2AuthenticationToken token = new CustomSaml2AuthenticationToken(principal, xmlResponse);
        System.out.println("Principal: " + token.getPrincipal());
        System.out.println("XML Response: " + token.getXmlResponse());
    }
}