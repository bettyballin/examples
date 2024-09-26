import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1437 {
    public static void main(String[] args) {
        try {
            // Simulating publicKeyBytes and inputData (you should replace these with actual values)
            String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy8Dbv8prpJ/0kKhlGeJYozo2t60EG8L0561g13R29LvMR5hyvGZlGJpmn65+A4xHXInJYiPuKzrKunApeLZ+vw1HocOAZtWK0z3r26uA8kQYOKX9Qt/DbCdvsF9wF8gRK0ptx9M6R13NvBxvVQApfc9jB9nTzphOgM4JiEYvlV8FLhg9yZovMYd6Wwf3aoXK891VQxTr/kQYoq1Yp+68i6T4nNq7NWC+UNVjQHxNQMQMzU6lWCX8zyg3yH88OAQkUXIXKfQ+NkvYQ1cxaMoVPpMCHwA9J8m2q5QgR8+Q7d1c+9uFeM5g0muGusZ6oe3Xl7aEuMjBcT+KjZwWl8QkMc9zYQ88aXmVg6jCwIDAQAB"; // Replace with your actual public key
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
            String inputData = "Hello, World!"; // Replace with your input data

            byte[] encryptedData = encrypt(publicKeyBytes, inputData.getBytes());
            System.out.println(Base64.getEncoder().encodeToString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] publicKeyBytes, byte[] data) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }
}