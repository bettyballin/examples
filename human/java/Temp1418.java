import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1418 {
    public static void main(String[] args) {
        try {
            String hexString = "539B333B39706D149028CFE1D9D4A407";
            byte[] cipherText = hexStringToByteArray(hexString);

            String keyString = "8000000000000000000000000000000000000000000000000000000000000001";
            byte[] keyBytes = hexStringToByteArray(keyString);

            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedText = cipher.doFinal(cipherText);
            System.out.println(bytesToHex(decryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}