import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Temp838 {
    private static final String encryptionKey = "1234567812345678"; // Example key

    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            byte[] bb = "exampletext".getBytes(StandardCharsets.UTF_8); // Example plaintext
            byte[] encryptedBytes = cipher.doFinal(bb);

            // Convert the byte array back to an integer array
            int[] t = convertByte2Int(encryptedBytes);
            System.out.println(Arrays.toString(t));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] convertByte2Int(byte[] byteArray) {
        int[] intArray = new int[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            intArray[i] = byteArray[i] & 0xFF; // Convert byte to int
        }
        return intArray;
    }
}