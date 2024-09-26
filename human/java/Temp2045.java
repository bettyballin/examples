import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class Temp2045 {
    public static void main(String[] args) throws Exception {
        // Sample data to encrypt
        byte[] data = new byte[256];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        byte[] encrypted = new byte[256];

        // Generate a key for AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // GCM parameters
        byte[] iv = new byte[12];
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

        cipher.updateAAD(data, 0, 128);              // first 128 bits are authenticated
        cipher.update(data, 128, 128, encrypted, 0); // next 128 are encrypted

        System.out.println("Encryption complete");
    }
}