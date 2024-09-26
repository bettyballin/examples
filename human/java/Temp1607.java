import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class Temp1607 {

    public static void main(String[] args) {
        byte[] key = "thisisaverysecretkey".getBytes();
        byte[] data = "This is some data to encrypt.".getBytes();

        byte[] keyEnc = hkdf(key, "Encryption");
        byte[] keyMac = hkdf(key, "MAC");
        byte[] ciphertext = encrypt(data, keyEnc);
        byte[] authTag = hmacSha256(keyMac, ciphertext);
        byte[] combined = new byte[ciphertext.length + authTag.length];
        System.arraycopy(ciphertext, 0, combined, 0, ciphertext.length);
        System.arraycopy(authTag, 0, combined, ciphertext.length, authTag.length);

        System.out.println(Arrays.toString(combined));
    }

    public static byte[] hkdf(byte[] key, String info) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key);
            byte[] prk = digest.digest(info.getBytes());

            digest.reset();
            digest.update(prk);
            byte[] okm = digest.digest(info.getBytes());

            return Arrays.copyOf(okm, 16); // return a 128-bit key
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] data, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]); // zero IV
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] hmacSha256(byte[] key, byte[] data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec keySpec = new SecretKeySpec(key, "HmacSHA256");
            mac.init(keySpec);
            return mac.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}