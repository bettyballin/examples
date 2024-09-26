import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import java.math.BigInteger;

public class Temp3572 {
    public static void main(String[] args) {
        String publicKeyBase64 = "YOUR_PUBLIC_KEY_BASE64";
        String apiKey = "YOUR_API_KEY";
        try {
            String bearerToken = GetBearerToken(publicKeyBase64, apiKey);
            System.out.println(bearerToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String GetBearerToken(String publicKeyBase64, String apiKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKeyBase64);
        
        // Assuming the key is in X.509 format
        BigInteger modulus = new BigInteger(1, keyBytes);
        BigInteger exponent = new BigInteger("65537"); // Common public exponent
        
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] dataToEncrypt = apiKey.getBytes("UTF-8");
        byte[] encryptedBytes = cipher.doFinal(dataToEncrypt);

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}