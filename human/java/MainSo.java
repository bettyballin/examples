import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainSo {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        System.out.println("https://stackoverflow.com/questions/63263081/node-js-encryption-code-to-java-encryption-code");

        String plaintext = "HelloWorld";
        String keyString =  "XXXXXXXX00000000"; // 16 chars
        byte[] key = keyString.getBytes(StandardCharsets.UTF_8);
        // md5 hashing is unsecure !!
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] keyMd5 = md.digest(key);
        // aes ecb mode encryption is unsecure
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyMd5, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        System.out.println("ciphertext Java:   " + bytesToHex(ciphertext));
        System.out.println("ciphertext NodeJS: " + "ce25d577457cf8113fa4d9eb16379529");
    }
    private static String bytesToHex(byte[] bytes) {
        // service method for displaying a byte array as hex string
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}