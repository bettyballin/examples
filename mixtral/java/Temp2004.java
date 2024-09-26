import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.MGF1ParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.spec.PSource;

public class Temp2004 {
    public static void main(String[] args) throws Exception {
        String customLabel = "my_custom_label";
        byte[] labelBytes = customLabel.getBytes(StandardCharsets.UTF_8);

        OAEPParameterSpec oaepParams = new OAEPParameterSpec(
            "SHA-256",
            "MGF1",
            MGF1ParameterSpec.SHA1,
            new PSource.PSpecified(labelBytes)
        );

        // For demonstration purposes, a sample public key in Base64 encoded form
        String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr0fK9O7F7L7pNf3kmiV+blb9vK6Q5cDB9VJ1y4g6+5lF1Z9C5L3TzZpQ5GdP8vJ3WQ5D5K1k2QZ4Gz+oNScq9iI2B7OX5K9N5i3xk3QWL6G4C+T4mU1a2+2G5h2F9T2u+L5lF8kRk2w1+mX2nYd5Q5GdP8vJ3WQ5D5K1k2QZ4Gz+oNScq9iI2B7OX5K9N5i3xk3QWL6G4C+T4mU1a2+2G5h2F9T2u+L5lF8kRk2w1+mX2nYd5Q5GdP8vJ3WQ5D5K1k2QZ4Gz+oNScq9iI2B7OX5K9N5i3xk3QWL6G4C+T4mU1a2+2G5h2F9T2u+L5lF8kRk2w1+mX2nYd5Q5GdP8vJ3WQ5D5K1k2QZ4Gz+oNScq9iI2B7OX5K9N5i3xk3QWL6G4C+T4mU1a2+2G5h2F9T2u+L5lF8kRk2w1+mX2nYd5Q5GdP8vJ3WQ5D5K1k2QZ4Gz+oNScq9iI2B7OX5K9N5i3xk3QWL6G4C+T4mU1a2+2G5h2F9T2u+L5lF8kRk2w1+mX2nYd5Q5GdP8vJ3WQ5D5K1k2QZ4Gz+oNSc";
        
        // Decode the public key
        byte[] decodedKey = Base64.getDecoder().decode(publicKeyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);

        // Sample plaintext
        String plaintext = "Hello, world!";
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        System.out.println(Base64.getEncoder().encodeToString(ciphertext));
    }
}