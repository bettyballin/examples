import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.BufferedBlockCipher;

public class Temp420 {
    public static void main(String[] args) {
        // Your key should be a byte array of the appropriate length for AES (16, 24, or 32 bytes)
        byte[] yourKey = new byte[16]; // Example key (you should use a proper key)
        byte[] inputData = new byte[16]; // Example input data (you should use your actual data)
        
        AESEngine engine = new AESEngine();
        CipherParameters params = new KeyParameter(yourKey);
        BufferedBlockCipher cipher = new BufferedBlockCipher(engine);
        cipher.init(true, params);
        
        int outputLength = cipher.getOutputSize(inputData.length);
        byte[] outBytes = new byte[outputLength];

        // Encryption
        int processed = cipher.processBytes(inputData, 0, inputData.length, outBytes, 0);
        try {
            processed += cipher.doFinal(outBytes, processed);
        } catch (CryptoException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Print the encrypted bytes
        for (byte b : outBytes) {
            System.out.printf("%02x ", b);
        }
    }
}