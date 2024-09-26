import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main75 {
    public static String toHex(byte[] arg) {
        StringBuilder hexString = new StringBuilder(2 * arg.length);
        for (byte b : arg) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; // example key
            String data = "example data"; // example data

            // Setup cipher
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt data
            byte[] encryptedData = cipher.doFinal(data.getBytes());

            // Convert to Hex String
            String encryptedHexString = toHex(encryptedData);
            System.out.println("Encrypted (hex): " + encryptedHexString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}