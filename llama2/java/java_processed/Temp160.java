import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import java.security.SecureRandom;
import java.util.Arrays;

public class Temp160 {
    public static void main(String[] args) {
        try {
            // Generate a 256-bit key
            SecureRandom secureRandom = new SecureRandom();
            byte[] key = new byte[32];
            secureRandom.nextBytes(key);

            KeyParameter kp = new KeyParameter(key);

            // Generate a 128-bit IV (Initialization Vector)
            byte[] iv = new byte[16];
            secureRandom.nextBytes(iv);

            // Create an AES engine with CBC mode and PKCS7 padding
            CBCBlockCipher cbcBlockCipher = new CBCBlockCipher(new AESFastEngine());
            PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cbcBlockCipher, new PKCS7Padding());

            // Encrypt
            cipher.init(true, new ParametersWithIV(kp, iv));
            byte[] plaintext = "Hello World!".getBytes();
            byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.length)];
            int ctLength = cipher.processBytes(plaintext, 0, plaintext.length, ciphertext, 0);
            ctLength += cipher.doFinal(ciphertext, ctLength);
            ciphertext = Arrays.copyOf(ciphertext, ctLength);

            // Decrypt
            cipher.init(false, new ParametersWithIV(kp, iv));
            byte[] decrypted = new byte[cipher.getOutputSize(ciphertext.length)];
            int ptLength = cipher.processBytes(ciphertext, 0, ciphertext.length, decrypted, 0);
            ptLength += cipher.doFinal(decrypted, ptLength);
            decrypted = Arrays.copyOf(decrypted, ptLength);

            System.out.println("Decrypted: " + new String(decrypted));
        } catch (CryptoException | InvalidCipherTextException e) {
            e.printStackTrace();
        }
    }
}