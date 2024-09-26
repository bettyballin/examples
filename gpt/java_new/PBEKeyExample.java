import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.security.spec.KeySpec;

public class PBEKeyExample {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String password = "mySecretPassword";
        byte[] salt = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
        int iterationCount = 10000;
        int keyLength = 256;

        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBEWITHHMACSHA256ANDAES_256", "BC");
        SecretKey secretKey = skf.generateSecret(pbeKeySpec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] plaintext = "Hello, World!".getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);

        System.out.println("Ciphertext: " + javax.xml.bind.DatatypeConverter.printHexBinary(ciphertext));
    }
}