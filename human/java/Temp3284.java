import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class Temp3284 {
    public static void main(String[] args) {
        try {
            String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNvs/qUMjkfq2E9o0qn03+KJE7" +
                            "ASczEbn6q+kkthNBdmTsskikWsykpDPnLWhAVkmjz4alQyqw+mHYP9xhx8qUC4A3" +
                            "tXY0ObxANUUKhUvR7zNj4vk4t8F2nP3erWvaG8J+sN3Ubr40ZYIYLS6UHYRFrqRD" +
                            "CDhUtyjwERlz8KhLyQIDAQAB";

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pubKey));
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            byte[] plaintext = "The quick brown fox jumps over the lazy dog".getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = encrypt(publicKey, plaintext);

            System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(PublicKey publicKey, byte[] plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plaintext);
    }
}