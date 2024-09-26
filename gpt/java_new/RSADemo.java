import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class RSADemo {
    public static void main(String[] args) throws Exception {
        String clearTextPassword = "XXXXX";
        String modulusBase64 = "YOUR_MODULUS_BASE64";
        String exponentBase64 = "YOUR_EXPONENT_BASE64";

        // Decode the base64 encoded string
        byte[] modulusBytes = java.util.Base64.getDecoder().decode(modulusBase64);
        byte[] exponentBytes = java.util.Base64.getDecoder().decode(exponentBase64);

        // Create RSA public key
        BigInteger modulus = new BigInteger(1, modulusBytes);
        BigInteger exponent = new BigInteger(1, exponentBytes);
        RSAPublicKeySpec publicSpec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicSpec);

        // Encrypt the clear text password
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(clearTextPassword.getBytes());

        // Encode the encrypted password bytes to base64
        String encryptedPasswordBase64 = java.util.Base64.getEncoder().encodeToString(encryptedBytes);

        // Output the encrypted password in base64 format
        System.out.println("Encrypted Password (Base64): " + encryptedPasswordBase64);
    }
}