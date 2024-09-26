import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.interfaces.RSAPrivateKey;

public class Temp1108 {
    public static void main(String[] args) {
        try {
            // Dummy privateKeyBytes for demonstration purposes
            byte[] privateKeyBytes = java.util.Base64.getDecoder().decode("MIIBVgIBADANBgkqhkiG9w0BAQEFAASCATwwggE4AgEAAkEAmrBQ3lQ5B9z5P4R1mF7j+XzNhQ2+7PZpG1U4vP2RcdvT1g4P3m4R3W2lJx4YkP5kQ7c5Fv5J4as0wtL4X2N9wIDAQABAkAgV3iV5JZJNi5l9fFjE9B7xw4H5q5Jx3gWbO8vIj8F6Q+YjRMrxJAD3gXoBvWj1j9Wg8uJZ6a8/l4Y1Jy6L8xAiEA9fukvOQvA8G2+v9gZ4u6k8bQYcN6d7n5J8A+K0fbNK0CIQCiYwH5V3/o8rO6Er8c3nNQzaMr5f9M0M3j5V5p+Z7sirwIhALXL7HEQj/1L0QF0Z9ZbW3AyF3zI9gqgxyB8g6xKcH4/AiBvS9zJ9O2hCdoT3Ag7Q5H7B/0bwhAu7P4956Gq9J4QkQIhAOm7s1O5Qk5S5JwD9Z7OZ8fD9y7zqg0d7KqP5U2q4n8o");

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
            RSAPrivateKey privKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);
            BigInteger pKeyModulus = privKey.getModulus();

            System.out.println("Modulus: " + pKeyModulus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}