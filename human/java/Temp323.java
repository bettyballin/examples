import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class Temp323 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("test.aes");
            DataInputStream dataIn = new DataInputStream(in);

            // stream key and message
            byte[] rawKey = new byte[16];
            dataIn.read(rawKey);
            byte encryptedMessageLen = dataIn.readByte();
            byte[] encryptedMessage = new byte[encryptedMessageLen];
            dataIn.read(encryptedMessage);

            // use CBC/PKCS5Padding, with 0 IV
            SecretKeySpec sessionKey = new SecretKeySpec(rawKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, sessionKey, new IvParameterSpec(new byte[16]));

            byte[] decryptedBlocks = cipher.doFinal(encryptedMessage);

            // check versus expected message
            byte[] expectedBytes = "Decryption Works -- using multiple blocks".getBytes();
            if (Arrays.equals(decryptedBlocks, expectedBytes)) {
                System.out.println("Decryption successful and message matches expected.");
            } else {
                System.out.println("Incorrect Message: " + new String(decryptedBlocks));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}