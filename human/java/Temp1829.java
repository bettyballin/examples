import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1829 {
    public static void main(String[] args) {
        try {
            String str = "CB5E759CE5FEAFEFCC9BABBFD84DC80C0291ED4917CF1402FF03B8E12716E44C";
            String key = "test";
            
            String ivHex = str.substring(0, 32);
            String ciphertextHex = str.substring(32);

            byte[] iv = hexStringToByteArray(ivHex);
            byte[] ciphertext = hexStringToByteArray(ciphertextHex);
            byte[] keyBytes = sha1(key).substring(0, 16).getBytes();

            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(ciphertext);

            System.out.println("Result: " + new String(decrypted, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sha1(String input) throws Exception {
        java.security.MessageDigest mDigest = java.security.MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}