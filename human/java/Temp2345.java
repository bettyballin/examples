import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2345 {
    public static void main(String[] args) {
        try {
            String input = "a";
            String key = "b38b730d4cc721156e3760d1d58546ce697adc939188e4c6a80f0e24e032b9b7";
            String iv = "064df9633d9f5dd0b5614843f6b4b059";

            byte[] keyBytes = hexStringToByteArray(key);
            byte[] ivBytes = hexStringToByteArray(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(input.getBytes("UTF-8"));
            String encoded = Base64.getEncoder().encodeToString(encrypted);

            System.out.println(encoded);
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
}