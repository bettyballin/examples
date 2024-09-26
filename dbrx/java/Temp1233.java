import java.util.Base64;

public class Temp1233 {
    public static void main(String[] args) {
        String cH = "your_base64_string_here";
        String sharedKey = "your_shared_key_here";

        byte[] decodedBytes = Base64.getDecoder().decode(cH);
        String msgH = RC4.decrypt(decodedBytes, sharedKey);
        System.out.println("Deciphered Message: " + msgH);
    }
}

class RC4 {
    public static String decrypt(byte[] data, String key) {
        try {
            byte[] result = new byte[data.length];

            byte[] keyBytes = key.getBytes("UTF-8");
            int[] s = new int[256];
            for (int i = 0; i < 256; i++) {
                s[i] = i;
            }

            int j = 0;
            for (int i = 0; i < 256; i++) {
                j = (j + s[i] + keyBytes[i % keyBytes.length]) & 0xFF;
                int temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }

            int i = 0;
            j = 0;
            for (int k = 0; k < data.length; k++) {
                i = (i + 1) & 0xFF;
                j = (j + s[i]) & 0xFF;
                int temp = s[i];
                s[i] = s[j];
                s[j] = temp;

                result[k] = (byte)(data[k] ^ s[(s[i] + s[j]) & 0xFF]);
            }

            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}