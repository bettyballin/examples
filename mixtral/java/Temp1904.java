import java.security.Security;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1904 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM", "BC");
    }
}