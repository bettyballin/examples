import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSACipher {
    
    public String encryptStringWithPublicKey(String input, String publicKeyPEM) throws Exception {
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
        publicKeyPEM = publicKeyPEM.replaceAll("\\s", "");
        
        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        
        return Base64.getEncoder().encodeToString(cipherText);
    }
    
    // Example usage
    public static void main(String[] args) {
        String yourPublicKeyPem = "-----BEGIN PUBLIC KEY-----
...
-----END PUBLIC KEY-----";
        String yourString = "Your string to encrypt";
        
        RSACipher rsaCipher = new RSACipher();
        try {
            String encryptedString = rsaCipher.encryptStringWithPublicKey(yourString, yourPublicKeyPem);
            System.out.println("Encrypted String: " + encryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}