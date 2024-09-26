import java.math.BigInteger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import java.security.SecureRandom;

public class Temp493 {
    public static void main(String[] args) {

        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();

            // Generate IV
            byte[] iv = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Convert IV to hexadecimal string
            String hexIV = new BigInteger(1, ivSpec.getIV()).toString(16);
            hexIV = hexIV.replaceFirst("^0+(?!$)", "");

            System.out.println("Generated AES Key: " + new BigInteger(1, secretKey.getEncoded()).toString(16));
            System.out.println("Generated IV in hex: " + hexIV);

            // Example of encryption and decryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            String plaintext = "Hello, World!";
            byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
            System.out.println("Ciphertext: " + new BigInteger(1, ciphertext).toString(16));

            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] decryptedText = cipher.doFinal(ciphertext);
            System.out.println("Decrypted text: " + new String(decryptedText));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}