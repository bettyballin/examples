import java.security.Security;
import sun.security.provider.Sun;
import sun.security.rsa.SunRsaSign;
import com.sun.net.ssl.internal.ssl.Provider;
import com.sun.crypto.provider.SunJCE;
import sun.security.jgss.SunProvider;
import com.sun.security.sasl.Provider;
import org.jcp.xml.dsig.internal.dom.XMLDSigRI;
import sun.security.smartcardio.SunPCSC;

public class Temp67 {
    public static void main(String[] args) {
        Security.addProvider(new Sun());
        Security.addProvider(new SunRsaSign());
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Security.addProvider(new SunJCE());
        Security.addProvider(new SunProvider());
        Security.addProvider(new com.sun.security.sasl.Provider());
        Security.addProvider(new XMLDSigRI());
        Security.addProvider(new SunPCSC());

        System.out.println("Security providers added successfully.");
    }
}