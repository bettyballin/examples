import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.KeyFactory;
import java.util.Base64;

public class Temp124 {
    public static void main(String[] args) throws Exception {
        // Example usage
        String filePath1 = "path/to/private/key";
        String encrypted = "your_encrypted_string";
        System.out.println(decrypt(filePath1, encrypted));
    }

    public static String decrypt(String filePath1, String encrypted) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        InputStream stream = new FileInputStream(filePath1);

        byte[] encodedKey1 = new byte[stream.available()];

        // Read the key bytes
        stream.read(encodedKey1);
        stream.close();

        PKCS8EncodedKeySpec privateKeySpec1 = new PKCS8EncodedKeySpec(encodedKey1);

        KeyFactory kf1 = KeyFactory.getInstance("RSA");

        PrivateKey pkPrivate1 = kf1.generatePrivate(privateKeySpec1);

        Cipher pkCipher1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Initialize the cipher with private key
        pkCipher1.init(Cipher.DECRYPT_MODE, pkPrivate1);

        byte[] decoded = Base64.getDecoder().decode(encrypted);

        return new String(pkCipher1.doFinal(decoded));
    }
}