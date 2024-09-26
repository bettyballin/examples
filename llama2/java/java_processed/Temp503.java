import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.io.IOException;

public class Temp503 {

    public static void main(String[] args) {
        try {
            String stored = "YOUR_BASE64_ENCODED_PUBLIC_KEY";
            PublicKey publicKey = loadPublicKey(stored);
            System.out.println("Public Key: " + publicKey);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        byte[] data = Base64.getDecoder().decode(stored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
    }
}