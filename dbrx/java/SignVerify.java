Here is the corrected Java code:


import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignVerify {
    public static void main(String[] args) throws Exception {
        // Replace these with your actual keys
        String privateKeyPEM = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC3NzaC1lE6t9B3\n" +
                "7DgCAc0/Km0H8w8xzmTcPtluN6Ww6D4h3LK/5QgX8RrCPge2fKq3r/b0zLHsVcbv\n" +
                "IkDz3NM7w38Tc8w2fKUb9k6p31tj3CCMGjE5m2LgW7tEw3edpNxZIlG+CQvJf3z\n" +
                "S4ZsVXl5BMT2CSQKZX1+6jF8mLwD5f6h2QlVeoH+1qNjFj9x+gjkljgQwYkRNV1\n" +
                "1HFXuOFOUEiNjD1u8yvMPYQVcW9EvLj5b5w14VR3bds9vCEB6WiBqF13AylPBJX\n" +
                "R4b2F5zHg9wGqVv3fTQgT5f2fYl9GfCuN/nniWU+oP0wIwQJuc2AHX1xegm1rCc\n" +
                "9y+0QvDwIDAQABAoIBAHKOyJ6QO9R3xh7HnV5xPSaL2YK4yA9YE7N3YMm1rFkA\n" +
                "Mh2n8j3bV2GpAAL5+Gf3P4A+ov2f56D4T7Xv/iQj2PJ7xJUyJt+7wB4v9fyp61\n" +
                "L6Vo8krYTpykWYKpoDg1W2q4xMg3mP4rLlL5XKQgVl9+qT6fDQ7m9xtKMiSSE2\n" +
                "I6Ip/2jFwvQvMpr+P/hT5SjB8J9W9qgGpRd3+6NFjLGp7p0UkGMvZh8JYQhY3U\n" +
                "RUS+1MGP15MySJL3Zb8QxYE3db+3UKva8ZfW+XwDghrrK3BpJwtK8Q2wIwQJuc2\n" +
                "AHX1xegm1rCc9y+0QvDwECgYEA9mZtyyXjK4M5+7wB4v9fyp61L6Vo8krYTpyk\n" +
                "WYKpoDg1W2q4xMg3mP4rLlL5XKQgVl9+qT6fDQ7m9xtKMiSSE2I6Ip/2jFwvQv\n" +
                "Mpr+P/hT5SjB8J9W9qgGpRd3+6NFjLGp7p0UkGMvZh8JYQhY3URUS+1MGP15My\n" +
                "SJL3Zb8QxYE3db+3UKva8ZfW+XwDghrrK3BpJwtK8Q=\n" +
                "-----END PRIVATE KEY-----";
        String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3NzaC1lE6t9B37DgCA\n" +
                "c0/Km0H8w8xzmTcPtluN6Ww6D4h3LK/5QgX8RrCPge2fKq3r/b0zLHsVcbvIkD\n" +
                "z3NM7w38Tc8w2fKUb9k6p31tj3CCMGjE5m2LgW7tEw3edpNxZIlG+CQvJf3zS4\n" +
                "ZsVXl5BMT2CSQKZX1+6jF8mLwD5f6h2QlVeoH+1qNjFj9x+gjkljgQwYkRNV11\n" +
                "HFXuOFOUEiNjD1u8yvMPYQVcW9EvLj5b5w14VR3bds9vCEB6WiBqF13AylPBJX\n" +
                "R4b2F5zHg9wGqVv3fTQgT5f2fYl9GfCuN/nniWU+oP0wIDAQAB\n" +
                "-----END PUBLIC KEY-----";
        
        // Remove the first and last lines
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "")
                                     .replace("-----END PRIVATE KEY-----", "")
                                     .replaceAll("\\s", "");
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "")
                                   .replace("-----END PUBLIC KEY-----", "")
                                   .replaceAll("\\s", "");

        // Decode the PEM data
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM);

        // Generate the private and public key
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        String message = "your_message_here";

        // Sign the message
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signedData = signature.sign();

        // Verify the signature
        Signature signatureVerify = Signature.getInstance("SHA256withRSA");
        signatureVerify.initVerify(publicKey);
        signatureVerify.update(message.getBytes());
        boolean isVerified = signatureVerify.verify(signedData);

        System.out.println("Signature Verified: " + isVerified);
    }
}