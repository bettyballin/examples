public class Temp3357 {
    public static void main(String[] args) {
        String clientName = "myAuthProvider";
        String clientId = "ABCID";
        String clientSecret = "XYZSECRET";
        String clientAuthenticationMethod = "basic";
        String authorizationGrantType = "authorization_code";
        String redirectUri = "{baseUrl}/welcome/login/oauth2/code/{registrationId}";

        System.out.println("Client Name: " + clientName);
        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
        System.out.println("Client Authentication Method: " + clientAuthenticationMethod);
        System.out.println("Authorization Grant Type: " + authorizationGrantType);
        System.out.println("Redirect URI: " + redirectUri);
    }
}