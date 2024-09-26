import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import static java.nio.charset.StandardCharsets.UTF_8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class BouncyLightWeightCipherExample {

    private static final boolean FOR_DECRYPTION = false;

    public static void main(String[] args) throws Exception {
        final byte[] keyData = new byte[256 / Byte.SIZE];
        final byte[] ivData = new byte[16];
        final byte[] testData = "owlstead".getBytes(UTF_8);

        final Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyData, "AES"), new IvParameterSpec(ivData));
        final byte[] ciphertext = c.doFinal(testData);

        final BlockCipher blockCipher = new AESFastEngine();
        final CBCBlockCipher withModeOfOperation = new CBCBlockCipher(blockCipher);
        final PaddedBufferedBlockCipher withPadding = new PaddedBufferedBlockCipher(withModeOfOperation);
        final ParametersWithIV keyAndIV = new ParametersWithIV(new KeyParameter(keyData), ivData);
        withPadding.init(FOR_DECRYPTION, keyAndIV);
        final byte[] plaintext = new byte[withPadding.getOutputSize(ciphertext.length)];
        int plaintextLength = withPadding.processBytes(ciphertext, 0, ciphertext.length, plaintext, 0);
        plaintextLength += withPadding.doFinal(plaintext, plaintextLength);

        System.out.println(new String(plaintext, 0, plaintextLength, UTF_8));
    }
}