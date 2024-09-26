import java.io.FileInputStream;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp514 {
    public static void main(String[] args) {
        try {
            // Replace with your own private key in base64 encoded PKCS8 format
            String privateKeyPEM = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD3w5fL2zYv...";

            byte[] encodedPrivateKey = Base64.getDecoder().decode(privateKeyPEM);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);

            FileInputStream inStream = new FileInputStream("manifest");
            byte[] buffer = new byte[8192];
            int len;
            while ((len = inStream.read(buffer)) >= 0) {
                signature.update(buffer, 0, len);
            }
            inStream.close();

            byte[] realSig = signature.sign();
            System.out.println(Base64.getEncoder().encodeToString(realSig));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}