import org.bouncycastle.util.encoders.Base64;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;

public class Temp1014 {
    public static void main(String[] args) {
        // Example usage
        // This is a placeholder, you need to provide a valid ECPrivateKey and content
        // ECPrivateKey key = ...;
        // byte[] content = ...;
        // try {
        //     String signature = ecdsaSign(key, content);
        //     System.out.println(signature);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    private static String ecdsaSign(ECPrivateKey key, byte[] content) throws Exception {
        Signature ecdsaSign = Signature.getInstance("SHA256withECDSA", "BC");
        ecdsaSign.initSign(key);
        ecdsaSign.update(content);
        byte[] signature = ecdsaSign.sign();
        
        // Encode the signature as Base64
        String base64Signature = new String(Base64.encode(signature));
        return base64Signature;
    }
}