import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1881 {
    public static void main(String[] args) {
        try {
            Temp1881 temp = new Temp1881();
            String data = "Sample data";
            String privateKeyString = "MIIBVwIBADANBgkqhkiG9w0BAQEFAASCATYwggEyAgEAAkEAq2V9c1E6gC7FZ4txQ0bZl1U6w6F2bs6bYvY5ft6ZxJ+1wIGyLpmZb5Hi5HkI1YpZL6vQ5bWz9kR3+g1/3H6fFPwIDAQABAkBo9+wc7gUHRwkv9bKnF9yP5JXX2XkW+szWc6Qy2S7i2qJZVBvK5aF0bEID7Qw5a5Nq3W8a2N1X+kmVekZwfbKBAiEA2D2W0m0YHk8dMZa4yHEKx8QX8qO5qF5P7zN0L1YBFZsCIQDGUHk2yb9X1g2fWJk9XwBz1zX3zC6dYxU5U4H+uNaO5wIgXH5w7zK7XvF8T9s4hZ9JYg8mW+z+P7PQkVxzX+R2N6ECIClzv3r4g5H0hV3QH8qzq7lW8Uu4s4ZRewW1iT7S6XApAiEAu+1J2D0n6e4mLH6NT2n7FT4a0k6z2vmhFqgJwP2N7jU=";
            String signedData = temp.signData(data, privateKeyString);
            System.out.println("Signed Data: " + signedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String signData(final String data, final String privateKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] sign = signature.sign();
        return Base64.getEncoder().encodeToString(sign);
    }
}