import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Temp215 {
    public static void main(String[] args) {
        try {
            Temp215 temp = new Temp215();
            String pub = "YOUR_PUBLIC_KEY_STRING_HERE"; // replace with actual public key string
            PublicKey publicKey = temp.convertStringToPublicKey(pub);
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PublicKey convertStringToPublicKey(String pub) throws Exception {
        byte[] sigBytes = Base64.getDecoder().decode(pub);

        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes);

        KeyFactory keyFact = KeyFactory.getInstance("RSA");

        PublicKey pubKey = keyFact.generatePublic(x509KeySpec);

        return pubKey;
    }
}