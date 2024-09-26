public class Temp1962 {
    public static void main(String[] args) {
        String grantType = "client_credentials";
        String clientId = "my id";
        String clientSecret = "my secret";
        String accessTokenUri = "https://bearer.token/get";

        System.out.println("Grant Type: " + grantType);
        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
        System.out.println("Access Token URI: " + accessTokenUri);
    }
}