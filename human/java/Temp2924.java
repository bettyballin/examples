import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp2924 {
    public static void main(String[] args) {
        try {
            // Generate a secret key for AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // or 192 or 256
            SecretKey secretKey = keyGen.generateKey();
            
            // Create a Cipher instance for AES encryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            String PLAINTEXT = "This is a secret message";

            // Get the output size and initialize the byte array
            byte[] opbytes = new byte[cipher.getOutputSize(PLAINTEXT.length())];

            // Encrypt the plaintext
            cipher.doFinal(PLAINTEXT.getBytes(), 0, PLAINTEXT.length(), opbytes, 0);
            
            // Print the encrypted bytes
            System.out.println("Encrypted bytes: ");
            for (byte b : opbytes) {
                System.out.print(b + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}