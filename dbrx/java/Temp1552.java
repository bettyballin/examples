import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1552 {
    public static void main(String[] args) throws Exception {
        // Example PEM-encoded RSA public key
        String pemKey = "-----BEGIN PUBLIC KEY-----\n" +
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7v1T8T0EUE8E1q4XD8s8\n" +
                        "R6Tmi9v4Gk3wY+E1m6VdJ6x3o7G9zL4nO6jJZB2S1Dg9oR0i9e5zEoW5uZ1NQ3dx\n" +
                        "aD1kN1bH4b8Vv5eW6vQx2u7RT3o3qo1T3pQgU4z8P6N1pA7zKJ6Q+5QG2bQ8U3Q7\n" +
                        "7wK9ElzOQ9JHjOkY5Y7t6+v9S4T1MszEVtJ0w4v0e2zXjK6y3Q4V2s9Z+3m6Pr5G\n" +
                        "3hF5ZbN5O7vK7v8RztE5J9E6p5T+4Yq8JcF7yKjZoY46m9Z5B5ZzJzXlj9oQh9W1\n" +
                        "Zz8nQ8E5a6sp1Oe5p8q6b+f5b5A5pF7+n5aQ5pR7+n5aQ5pR7+n5aQ5pR7+n5aQ5\n" +
                        "pR7+n5aQ5pR7+n5aQIDAQAB\n" +
                        "-----END PUBLIC KEY-----";

        // Remove the first and last lines
        String publicKeyPEM = pemKey.replace("-----BEGIN PUBLIC KEY-----\n", "")
                                    .replace("-----END PUBLIC KEY-----", "")
                                    .replaceAll("\\s", "");

        // Decode Base64
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM);

        // Create a KeyFactory and X509EncodedKeySpec
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");

        // Generate the public key
        PublicKey pubKey = kf.generatePublic(spec);
        
        // Print the public key
        System.out.println(pubKey);
    }
}