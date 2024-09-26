This is Java code, not C. However, I'll provide you with a complete Java code snippet that you can compile and run:

java
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String text = "Hello, World!";
        String key = "mysecretkey1234";

        Key aesKey = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
    }
}