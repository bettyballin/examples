import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Temp2212 {
    public static void main(String[] args) {
        String encryptedText = "your_base64_encrypted_string_here";
        System.out.println(decrypt(encryptedText));
    }

    public static String decrypt(String src) {
        String decrypted = "";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, makeKey(), makeIv());
            byte[] array = Base64.getDecoder().decode(src);
            byte[] encrypted = Arrays.copyOfRange(array, 16, array.length);
            decrypted = new String(cipher.doFinal(encrypted)).trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decrypted;
    }

    private static SecretKey makeKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static IvParameterSpec makeIv() {
        byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00); // A simple IV for demonstration; use a proper IV in real applications
        return new IvParameterSpec(iv);
    }
}