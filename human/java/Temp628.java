import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.security.cas.authentication.CasAuthenticationToken;

public class Temp628 {
    public static void main(String[] args) {
        // Dummy security context and authentication setup for demonstration purposes
        // In a real application, the security context would be populated by Spring Security
        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.setContext(ctx);

        // Dummy CasAuthenticationToken and Assertion setup
        // In a real application, these would be provided by the CAS client and Spring Security
        Assertion assertion = new Assertion() {
            @Override
            public String getPrincipal() {
                return "dummyPrincipal";
            }

            @Override
            public Map<String, Object> getAttributes() {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("FullName", "John Doe");
                return attributes;
            }
        };
        
        CasAuthenticationToken casToken = new CasAuthenticationToken(
            "key",
            "principal",
            "credentials",
            new ArrayList<>(),
            new ArrayList<>(),
            assertion
        );

        ctx.setAuthentication(casToken);

        // Retrieve the authentication token from the security context
        CasAuthenticationToken retrievedToken = (CasAuthenticationToken) ctx.getAuthentication();
        Assertion retrievedAssertion = retrievedToken.getAssertion();
        String user_fullName = (String) retrievedAssertion.getAttributes().get("FullName");

        // Print the full name
        System.out.println(user_fullName);
    }
}