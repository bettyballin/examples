import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2761 {
    public static void main(String[] args) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode("uQsaW+WMUrjcsq1HMf+2JQ==");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(keyBytes);

        String encryptedContent = "52F415AB673427C42278E8D6F34C16134D7E3FE7986500980ED4063F3CF51162592CE0F5412CCA0BC2DBAE3F2AEC2D585EE8D7";
        byte[] encryptedBytes = hexStringToByteArray(encryptedContent);

        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);

        System.out.println(decryptedText);
    }

    // Helper method to convert hex string to byte array
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