import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class Encrypt {
    private byte[] ivHotp;
    private SecretKey secretSharedKey;
    private SecretKey secretMacKey;

    public Encrypt(String encryptionKey, String macKey, String ivHotp) throws Exception {
        this.ivHotp = hexStr2Bytes(ivHotp);

        // Create AES keys
        byte[] sharedKeyData = hexStr2Bytes(encryptionKey);
        secretSharedKey = new SecretKeySpec(sharedKeyData, "AES");

        byte[] macKeyData = hexStr2Bytes(macKey);
        secretMacKey = new SecretKeySpec(macKeyData, "HMACSHA1");
    }

    public void encryptSingleSecret(String serialNo, String secret) throws Exception {
        // Create cipher and initialize it with AES key
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        IvParameterSpec ivParamSpec = new IvParameterSpec(ivHotp);

        byte[] secretBytes = hexStr2Bytes(secret);

        // Encrypt the plaintext
        aesCipher.init(Cipher.ENCRYPT_MODE, secretSharedKey, ivParamSpec);
        byte[] encryptedBytes = aesCipher.doFinal(secretBytes);

        // Print or return the encrypted data
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));
    }

    private byte[] hexStr2Bytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        try {
            Encrypt encrypt = new Encrypt("00112233445566778899AABBCCDDEEFF", "0123456789ABCDEFFEDCBA9876543210", "000102030405060708090A0B0C0D0E0F");
            encrypt.encryptSingleSecret("1234567890", "0011223344556677");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}