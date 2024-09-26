import java.security.Key;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.bouncycastle.util.encoders.Hex;

public class Temp1119 {
    public static void main(String[] args) throws Exception {
        byte[] key1Bytes = Hex.decode("your_key1");

        SecretKeyFactory factory1 = SecretKeyFactory.getInstance("DESede");

        DESedeKeySpec spec1 = new DESedeKeySpec(key1Bytes);

        Key secretKey1 = factory1.generateSecret(spec1);

        byte[] key2Bytes = Hex.decode("your_key2");

        SecretKeyFactory factory2 = SecretKeyFactory.getInstance("DESede");

        DESedeKeySpec spec2 = new DESedeKeySpec(key2Bytes);

        Key secretKey2 = factory2.generateSecret(spec2);
    }
}