import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Temp216 {
    public static void main(String[] args) {
        try {
            String pub = "yourPublicKeyStringHere"; // Replace with actual public key string
            PublicKey publicKey = convertStringToPublicKey(pub);
            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey convertStringToPublicKey(String pub) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(pub);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }
}