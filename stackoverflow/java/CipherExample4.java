import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class CipherExample4 {
    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey publicKey = null; // Initialize with actual public key
        PrivateKey privateKey = null; // Initialize with actual private key
        byte[] input = "Your input here".getBytes();

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherBytes = cipher.doFinal(input);

        String cipherText = Base64.getEncoder().encodeToString(cipherBytes);

        byte[] reCipherBytes = Base64.getDecoder().decode(cipherText);

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = cipher.doFinal(reCipherBytes);

        System.out.println("plain : " + new String(plainText));
    }
}