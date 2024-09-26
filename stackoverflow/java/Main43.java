import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import java.io.UnsupportedEncodingException;

public class Main43 {
    public static void main(String[] args) {
        try {
            PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());
            gen.init("password".getBytes("UTF-8"), "salt".getBytes(), 4096);
            byte[] dk = ((KeyParameter) gen.generateDerivedParameters(256)).getKey();
            // Use dk as needed
        } catch (UnsupportedEncodingException e) {
            // Handle encoding exception
        }
    }
}