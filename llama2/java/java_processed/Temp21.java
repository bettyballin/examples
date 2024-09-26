import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp21 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        try {
            // Key and data initialization
            byte[] keyBytes = new byte[16];
            new SecureRandom().nextBytes(keyBytes);
            KeyParameter key = new KeyParameter(keyBytes);

            byte[] ivBytes = new byte[16];
            new SecureRandom().nextBytes(ivBytes);

            byte[] input = "Hello, World!".getBytes();

            // Encrypt
            PaddedBufferedBlockCipher encryptCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()), new PKCS7Padding());
            encryptCipher.init(true, new ParametersWithIV(key, ivBytes));

            byte[] encrypted = processCipher(encryptCipher, input);

            // Decrypt
            PaddedBufferedBlockCipher decryptCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()), new PKCS7Padding());
            decryptCipher.init(false, new ParametersWithIV(key, ivBytes));

            byte[] decrypted = processCipher(decryptCipher, encrypted);

            // Display results
            System.out.println("Original: " + new String(input));
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
            System.out.println("Decrypted: " + new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] processCipher(PaddedBufferedBlockCipher cipher, byte[] input) throws Exception {
        byte[] output = new byte[cipher.getOutputSize(input.length)];
        int len = cipher.processBytes(input, 0, input.length, output, 0);
        len += cipher.doFinal(output, len);
        byte[] result = new byte[len];
        System.arraycopy(output, 0, result, 0, len);
        return result;
    }
}