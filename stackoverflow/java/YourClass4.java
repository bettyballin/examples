import java.security.PrivateKey;
import java.security.Signature;

public class YourClass4 {
    static public byte[] sign(byte[] data, PrivateKey privateKey, int saltLength) throws Exception {
        Signature instance = Signature.getInstance("RSASSA-PSS");
        instance.initSign(privateKey);
        instance.update(data);
        return instance.sign();
    }
}