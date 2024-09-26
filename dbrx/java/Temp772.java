import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class Temp772 {
    public static void main(String[] args) throws Exception {
        // Assuming privateKeyXml is the Base64 encoded PKCS#8 representation of private key.
        String privateKeyXml = "...";
        
        byte[] decodedPrivateKeyBytes = Base64.getDecoder().decode(privateKeyXml);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decodedPrivateKeyBytes);
        
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(spec);
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        byte[] encryptedData = "...".getBytes("UTF-8");
        byte[] decryptedData = cipher.doFinal(encryptedData);
        
        // Output decrypted data as a string
        System.out.println(new String(decryptedData, "UTF-8"));
    }
}