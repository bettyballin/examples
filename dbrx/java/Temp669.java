import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Temp669 {
    public static void main(String[] args) {
        try {
            String keyString1 = "your_base64_encoded_public_key_1";
            String keyString2 = "your_base64_encoded_public_key_2";
            
            byte[] keyBytes1 = Base64.getDecoder().decode(keyString1);
            byte[] keyBytes2 = Base64.getDecoder().decode(keyString2);

            X509EncodedKeySpec spec1 = new X509EncodedKeySpec(keyBytes1);
            X509EncodedKeySpec spec2 = new X509EncodedKeySpec(keyBytes2);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PublicKey key1 = keyFactory.generatePublic(spec1);
            PublicKey key2 = keyFactory.generatePublic(spec2);

            Temp669 temp = new Temp669();
            boolean result = temp.comparePublicKeys(key1, key2);
            System.out.println("Keys are equal: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean comparePublicKeys(PublicKey key1, PublicKey key2) {
        RSAPublicKey rsaKey1 = (RSAPublicKey) key1;
        RSAPublicKey rsaKey2 = (RSAPublicKey) key2;

        return rsaKey1.getModulus().equals(rsaKey2.getModulus()) &&
               rsaKey1.getPublicExponent().equals(rsaKey2.getPublicExponent());
    }
}