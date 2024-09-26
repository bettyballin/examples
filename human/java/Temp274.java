import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp274 {
    public static void main(String[] args) {
        try {
            String key = "00010203050607080a0b0c0d0f101112";
            byte[] keyBytes = hexStringToByteArray(key);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            System.out.println("Cipher initialized successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}