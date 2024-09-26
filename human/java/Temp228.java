import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp228 {

    public static void main(String[] args) throws Exception {
        // Assuming bm is a valid Bitmap object. Replace this with actual Bitmap initialization.
        // Bitmap bm = ...;

        // For demonstration, let's use a dummy byte array to simulate the bitmap data
        byte[] dummyBitmapData = "dummy bitmap data".getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(dummyBitmapData);
        byte[] b = baos.toByteArray();

        byte[] keyStart = "this is a key".getBytes();
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(keyStart);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        byte[] key = skey.getEncoded();

        // encrypt
        byte[] encryptedData = encrypt(key, b);
        // decrypt
        byte[] decryptedData = decrypt(key, encryptedData);

        // Print to verify
        System.out.println("Original Data: " + new String(b));
        System.out.println("Encrypted Data: " + new String(encryptedData));
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }

    public static byte[] encrypt(byte[] key, byte[] data) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] key, byte[] encryptedData) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(encryptedData);
    }
}