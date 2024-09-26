import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Temp2183 {
    public static void main(String[] args) {
        try {
            String encodedText = "pl26CH0sNT8gycZe0FVSVUpwH/moMaFpa6zMtZHcBKQ=";
            String key = "rakesh1@n1111111";
            String ivHex = "CE63BC477D1096B6F38CA77964CBD2CB";

            byte[] decodedText = Base64.getDecoder().decode(encodedText);
            byte[] iv = hexStringToByteArray(ivHex);
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decryptedBytes = cipher.doFinal(decodedText);
            String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

            System.out.println(decryptedText);
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