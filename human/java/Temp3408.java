public class Temp3408 {
    public static void main(String[] args) {
        String issuerUri = "https://example.com/issuer";
        String clientId = "my-client-id";
        String clientSecret = "my-client-secret";
        String authorizationGrantType = "authorization_code";
        String scope = "profile email";
        String authorizationUri = "https://example.com/auth";
        String tokenUri = "https://example.com/token";

        System.out.println("Security Configuration:");
        System.out.println("OAuth2 Resource Server:");
        System.out.println("  JWT:");
        System.out.println("    Issuer URI: " + issuerUri);
        System.out.println("OAuth2 Client:");
        System.out.println("  Registration:");
        System.out.println("    Keycloak:");
        System.out.println("      Client ID: " + clientId);
        System.out.println("      Client Secret: " + clientSecret);
        System.out.println("      Authorization Grant Type: " + authorizationGrantType);
        System.out.println("      Scope: " + scope);
        System.out.println("  Provider:");
        System.out.println("    Keycloak:");
        System.out.println("      Authorization URI: " + authorizationUri);
        System.out.println("      Token URI: " + tokenUri);
    }
}