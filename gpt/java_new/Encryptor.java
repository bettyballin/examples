import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import java.security.spec.AlgorithmParameterSpec;

public class Encryptor {
    private static final byte[] salt = {
        (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
        (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99
    };
    private static final int iterationCount = 20;
    private SecretKey key;

    public Encryptor(SecretKey key) {
        this.key = key;
    }

    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF8");
            Cipher localEcipher = Cipher.getInstance("PBEWithMD5AndDES");
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            localEcipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            byte[] enc = localEcipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}