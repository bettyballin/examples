import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class HelloWorldSender {
    private static final int AES_KEY_SIZE = 128; // or 256

    public void sendHelloWorld() {
        String msg = "hello world!";
        byte[] aesKeyBytes = new byte[AES_KEY_SIZE / 8];
        SecureRandom random = new SecureRandom();
        random.nextBytes(aesKeyBytes); // generate a random key
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes); // generate a random IV
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        try {
            SecretKeySpec aesKeySpec = new SecretKeySpec(aesKeyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKeySpec, ivSpec);

            byte[] encryptedData = cipher.doFinal(msg.getBytes("UTF-8"));

            // The encrypted data can now be sent or stored depending on your requirement
            // For example:
            // sendToServer(encryptedData); // you would need to implement this method

        } catch (Exception e) {
            e.printStackTrace(); // handle exception appropriately
        }
    }
}