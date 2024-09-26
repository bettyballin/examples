import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;

import java.security.SecureRandom;

public class Temp216 {
    public static void main(String[] args) {
        try {
            // Generate key
            SecureRandom random = new SecureRandom();
            CipherKeyGenerator keyGen = new CipherKeyGenerator();
            keyGen.init(new org.bouncycastle.crypto.KeyGenerationParameters(random, 128));
            byte[] key = keyGen.generateKey();

            // Encryption parameters
            byte[] nonce = new byte[12]; // GCM recommended nonce size is 12 bytes
            random.nextBytes(nonce);
            int macSize = 128; // 128-bit MAC
            byte[] associatedData = "associated data".getBytes();

            // Initialize cipher
            GCMBlockCipher cipher = new GCMBlockCipher(new AESEngine());
            AEADParameters parameters = new AEADParameters(new KeyParameter(key), macSize, nonce, associatedData);
            cipher.init(true, parameters);

            // Plaintext
            byte[] plaintext = "Hello, World!".getBytes();

            // Encrypt
            byte[] encryptedData = new byte[cipher.getOutputSize(plaintext.length)];
            int offset = cipher.processBytes(plaintext, 0, plaintext.length, encryptedData, 0);
            cipher.doFinal(encryptedData, offset);

            // Output encrypted data
            System.out.println("Encrypted data: " + bytesToHex(encryptedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}