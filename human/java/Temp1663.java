import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.io.ByteArrayOutputStream;

public class Temp1663 {

    public static void main(String[] args) throws Exception {
        // Assuming bm is your Bitmap object. Since Bitmap is Android-specific, replace it with a byte array for simplicity
        byte[] bm = "example bitmap data".getBytes(); // Placeholder for Bitmap data
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(bm);
        byte[] b = baos.toByteArray();

        byte[] keyStart = "encryption key".getBytes();
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(keyStart);
        kgen.init(128, sr);
        SecretKey skey = kgen.generateKey();
        byte[] key = skey.getEncoded();

        // encrypt
        byte[] encryptedData = encrypt(key, b);
        // decrypt
        byte[] decryptedData = decrypt(key, encryptedData);

        System.out.println("Original Data: " + Arrays.toString(b));
        System.out.println("Encrypted Data: " + Arrays.toString(encryptedData));
        System.out.println("Decrypted Data: " + Arrays.toString(decryptedData));
    }

    public static byte[] encrypt(byte[] key, byte[] data) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] key, byte[] encryptedData) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(encryptedData);
    }
}