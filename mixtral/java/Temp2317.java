import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Temp2317 {
    public static void main(String[] args) {
        try {
            byte[] keyBytes = new byte[16]; // 128-bit key (all zeros)
            byte[] ivBytes = new byte[16];  // 128-bit IV (all zeros)

            KeyParameter key = new KeyParameter(keyBytes);
            ParametersWithIV keyWithIv = new ParametersWithIV(key, ivBytes);

            PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
            cipher.init(true, keyWithIv);

            byte[] input = "Hello, World!".getBytes();
            byte[] output = new byte[cipher.getOutputSize(input.length)];

            int len = cipher.processBytes(input, 0, input.length, output, 0);
            cipher.doFinal(output, len);

            System.out.println(new String(output));

        } catch (CryptoException e) {
            e.printStackTrace();
        }
    }
}