import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp463 {
    public static void main(String[] args) {
        // Add your test cases or main logic here.
    }

    public static List<Byte> decrypt(List<Byte> bytes, byte[] key) throws Exception {
        // Convert List<Byte> to byte[]
        byte[] bytesArray = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            bytesArray[i] = bytes.get(i);
        }

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // Assuming you have some method to get the IV
        byte[] iv = new byte[16]; // Replace with actual IV
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new javax.crypto.spec.IvParameterSpec(iv));

        int lastBlockSize = 16; // Replace with the actual calculation of your final block size

        if (bytesArray.length == lastBlockSize) {
            return ByteConverter.toByteList(cipher.doFinal(bytesArray));
        } else {
            // Process full blocks
            byte[] decryptedBytes = cipher.update(bytesArray);

            // Handle the rest of your CBC implementation
            // Assuming you have a method to handle the rest
            return ByteConverter.toByteList(decryptedBytes);
        }
    }
}

class ByteConverter {
    public static List<Byte> toByteList(byte[] bytes) {
        List<Byte> byteList = new ArrayList<>();
        for (byte b : bytes) {
            byteList.add(b);
        }
        return byteList;
    }
}