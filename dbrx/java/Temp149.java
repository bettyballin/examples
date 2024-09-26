import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.DSAPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class Temp149 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        String algoName = "1.2.840.113549.1.1.1"; // Example algorithm name
        SubjectPublicKeyInfo spki = null; // This should be replaced with actual SubjectPublicKeyInfo

        if (algoName.equals("1.2.840.113549.1.1.1")) { // RSA encryption
            try {
                RSAPublicKey rsaPub = (RSAPublicKey) new JcaPEMKeyConverter().getPublicKey(spki);
                System.out.println("RSA Public Key: " + rsaPub);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (algoName.equals("1.3.14.3.2.26")) { // DSA signature
            try {
                DSAPublicKey dsaPub = (DSAPublicKey) new JcaPEMKeyConverter().getPublicKey(spki);
                System.out.println("DSA Public Key: " + dsaPub);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}