import java.io.FileInputStream;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.bcpg.ArmoredInputStream;

public class Temp808 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("path/to/your/public_key.asc");
            ArmoredInputStream armorIn = new ArmoredInputStream(in);
            PGPSecretKeyRing keyring = new PGPSecretKeyRing(PGPUtil.getDecoderStream(armorIn));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}