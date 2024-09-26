import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp4 {
    public static void main(String[] args) throws Exception {
        byte[] P1 = "Plaintext1".getBytes();
        byte[] P2 = "Plaintext2".getBytes();
        byte[] P3 = "Plaintext3".getBytes();

        // Generate a random IV
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);

        SecretKey secretKey = generateKey();

        byte[] C1 = encrypt(xor(P1, IV), secretKey, IV);
        byte[] C2 = encrypt(xor(P2, C1), secretKey, IV);
        byte[] C3 = encrypt(xor(P3, C2), secretKey, IV);

        System.out.println("C1: " + Arrays.toString(C1));
        System.out.println("C2: " + Arrays.toString(C2));
        System.out.println("C3: " + Arrays.toString(C3));
    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static byte[] xor(byte[] a, byte[] b) {
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }

    public static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] IV) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        return cipher.doFinal(plaintext);
    }
}