public class Temp3089 {
    public static void main(String[] args) {
        String keyAlgorithm = "RSA";
        String keyPath = "private-stage.der";
        String subject = "";
        String issuer = "";
        String audience = "";
        String claimKey = "";
        boolean claimValue = true;
        String tokenExpiryFrequency = "DAY";
        int tokenExpiryUnit = 1;
        String clientId = "";
        String clientSecret = "";
        String jwtTokenUrl = "";

        System.out.println("Key Algorithm: " + keyAlgorithm);
        System.out.println("Key Path: " + keyPath);
        System.out.println("Subject: " + subject);
        System.out.println("Issuer: " + issuer);
        System.out.println("Audience: " + audience);
        System.out.println("Claim Key: " + claimKey);
        System.out.println("Claim Value: " + claimValue);
        System.out.println("Token Expiry Frequency: " + tokenExpiryFrequency);
        System.out.println("Token Expiry Unit: " + tokenExpiryUnit);
        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
        System.out.println("JWT Token URL: " + jwtTokenUrl);
    }
}