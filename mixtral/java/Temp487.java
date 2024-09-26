import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp487 {
    public static void main(String[] args) {
        try {
            String key = "12345678"; // Example key, must be 8 bytes for DES
            String vector = "abcdefgh"; // Example IV, must be 8 bytes for DES
            String data = "This is a test data"; // Example data to encrypt

            Cipher enc = Cipher.getInstance("DES/CBC/PKCS5Padding");
            enc.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "DES"), new IvParameterSpec(vector.getBytes()));

            // Encrypt data in chunks
            byte[] inputData = data.getBytes(StandardCharsets.UTF_8);
            int maxChunkSize = enc.getBlockSize();
            List<Byte> cipherTextParts = new ArrayList<>();

            for (int i = 0; i < inputData.length; i += maxChunkSize) {
                int chunkLength = Math.min(maxChunkSize, inputData.length - i);

                byte[] encryptedPart = enc.update(Arrays.copyOfRange(inputData, i, i + chunkLength));

                for (byte b : encryptedPart) {
                    cipherTextParts.add(b);
                }
            }

            // Finalize encryption
            byte[] finalPart = enc.doFinal();
            for (byte b : finalPart) {
                cipherTextParts.add(b);
            }

            // Convert cipherTextParts to byte array
            byte[] cipherText = new byte[cipherTextParts.size()];
            for (int i = 0; i < cipherTextParts.size(); i++) {
                cipherText[i] = cipherTextParts.get(i);
            }

            // Print encrypted data as hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : cipherText) {
                hexString.append(String.format("%02X", b));
            }
            System.out.println("Encrypted data (hex): " + hexString.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}