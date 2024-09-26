import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.security.Signature;

public class Temp452 {
    public static void main(String[] args) {
        Temp452 temp = new Temp452();
        temp.init();
    }

    public void init() {
        Security.addProvider(new BouncyCastleProvider());
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp521r1");
        try {
            Signature signer = Signature.getInstance("SHA256withECDSA", BouncyCastleProvider.PROVIDER_NAME);
            System.out.println("Signer initialized: " + signer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}