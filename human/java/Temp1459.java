import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp1459 {
    public static void main(String[] args) {
        try {
            Temp1459 temp = new Temp1459();
            byte[] msg = "Hello, World!".getBytes();
            byte[] key = "1234567890123456".getBytes(); // 16-byte key for AES-128
            byte[] iv = "1234567890123456".getBytes(); // 16-byte IV for AES/CBC

            byte[] encryptedMsg = temp.encrypt(msg, key, iv);
            System.out.println("Encrypted Message: " + new String(encryptedMsg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] encrypt(byte[] msg, byte[] key, byte[] iv) throws Exception {
        // prepare key
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // prepare cipher
        String cipherALG = "AES/CBC/PKCS5Padding"; // use your preferred algorithm
        Cipher cipher = Cipher.getInstance(cipherALG);
        String string = cipher.getAlgorithm();

        // as iv (Initial Vector) is only required for CBC mode
        if (string.contains("CBC")) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        }

        byte[] encMessage = cipher.doFinal(msg);
        return encMessage;
    }
}