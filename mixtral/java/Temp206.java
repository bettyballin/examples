import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class Temp206 {
    public static void main(String[] args) {
        // Example usage
        byte[] keyBytes = new byte[24]; // must be 24 bytes for 3DES
        byte[] ivBytes = new byte[8]; // must be 8 bytes for 3DES
        byte[] dataBytes = new byte[24]; // example data

        byte[] decryptedData = decrypt3DESCBC(keyBytes, ivBytes, dataBytes);
        // Handle decryptedData...
    }

    public static byte[] decrypt3DESCBC(byte[] keyBytes, byte[] ivBytes, byte[] dataBytes) {
        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // Check if the provided key is 168 or 120 bits in length
            int expectedKeyLength;

            switch (keyBytes.length * 8 / 3) {
                case 192:
                    expectedKeyLength = 192 / 3;
                    break;

                case 160:
                    throw new IllegalArgumentException("Invalid key length for Triple DES");

                default:
                    // If the provided key is not a multiple of 8 bytes
                    // it will be padded to ensure that its size matches
                    expectedKeyLength = (keyBytes.length / 3) * 4;
            }

            SecretKeySpec newKey = new SecretKeySpec(Arrays.copyOfRange(keyBytes, 0, expectedKeyLength), "DESede");

            Cipher cipher = Cipher.getInstance("DESede/CBC/" + (expectedKeyLength == keyBytes.length ? "NoPadding" : "PKCS5Padding"));

            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);

            return cipher.doFinal(dataBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}