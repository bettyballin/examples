import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

public class Temp1689 {
    public static void main(String[] args) {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        // You can now set properties on the resource object if needed
        resource.setClientId("your-client-id");
        resource.setClientSecret("your-client-secret");
        resource.setAccessTokenUri("http://example.com/oauth/token");
        resource.setUserAuthorizationUri("http://example.com/oauth/authorize");
        resource.setScope(Arrays.asList("read", "write"));
        
        System.out.println("AuthorizationCodeResourceDetails object created successfully.");
    }
}