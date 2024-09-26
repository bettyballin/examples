import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Temp997 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String key = "1234567890123456";  // 16-byte key for AES

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             OutputStream outStream = new BufferedOutputStream(
                     new CipherOutputStream(new FileOutputStream(outputFile), initCipher(key)))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Encryption complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Cipher initCipher(String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher;
    }
}