import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class EncryptionUtils1 {

    public static void encryptStream(SecretKey key, InputStream in, OutputStream out) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        try (CipherOutputStream cos = new CipherOutputStream(out, cipher)) {
            byte[] block = new byte[8];
            int i;
            while ((i = in.read(block)) != -1) {
                cos.write(block, 0, i);
            }
        }
    }

    public static void decryptStream(SecretKey key, InputStream in, OutputStream out) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        try (CipherInputStream cis = new CipherInputStream(in, cipher)) {
            byte[] block = new byte[8];
            int i;
            while ((i = cis.read(block)) != -1) {
                out.write(block, 0, i);
            }
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        SecretKey key = null; // Obtain a key instance
        try (FileInputStream fis = new FileInputStream("inputFile");
             FileOutputStream fos = new FileOutputStream("encryptedFile")) {
            encryptStream(key, fis, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try (FileInputStream fis = new FileInputStream("encryptedFile");
             FileOutputStream fos = new FileOutputStream("decryptedFile")) {
            decryptStream(key, fis, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}