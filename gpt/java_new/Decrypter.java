import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Decrypter {

    public static String decrypt(String filePath, String encrypted)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException {

        // Read the private key from the file
        InputStream stream = new FileInputStream(filePath);
        byte[] encodedKey = new byte[stream.available()];
        stream.read(encodedKey);
        stream.close();

        // Generate the private key from the byte array
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        // Initialize the Cipher for DECRYPTION
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decode the base64 encrypted string and decrypt it
        byte[] cipherText = Base64.getDecoder().decode(encrypted);
        byte[] decryptedBytes = cipher.doFinal(cipherText);

        // Return the decrypted string
        return new String(decryptedBytes);
    }
}