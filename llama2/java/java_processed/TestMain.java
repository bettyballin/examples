import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class TestMain {

    public static void main(String[] args) throws Exception {
        String encodedStr = "Uryybjbeyq rkzehbqyb rkftfgbd rkzyecee rdqf rdqf rdqf rdqf rdqf rdqf rdqf rdqf";
        String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCu+K7e2TkLmUY9v/6pPUaPMEX7tfKpqKhpQWaW02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5JLZS2Vf8A3HNh4LG7tH1jw4B02dyRo9D1F5";

        // Decode the public key
        byte[] publicKeyBytes = Base64.decodeBase64(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Decode the encoded string
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decodedBytes = cipher.doFinal(Base64.decodeBase64(encodedStr));

        String decodedStr = new String(decodedBytes);
        System.out.println("Decoded string: " + decodedStr);
    }
}