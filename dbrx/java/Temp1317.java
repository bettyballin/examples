import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp1317 {
    public static void main(String[] args) {
        try {
            byte[] keyBytes = new byte[8]; // 8 bytes for DES key
            SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
            IvParameterSpec iv = new IvParameterSpec(new byte[8]); // 8 bytes for DES IV

            Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
            des.init(Cipher.ENCRYPT_MODE, key, iv);

            String plaintext = "Hello, World!";
            byte[] ciphertext = des.doFinal(plaintext.getBytes("UTF-8"));

            System.out.println("Ciphertext: " + new String(ciphertext, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}