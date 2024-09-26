import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class Temp1347 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            ks.load(null, null);

            Enumeration<String> aliases = ks.aliases();
            String alias = null;

            if (aliases.hasMoreElements()) {
                alias = aliases.nextElement();
            } else {
                throw new Exception("No alias found!");
            }

            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, null);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            byte[] dataToBeSigned = "Sample data to be signed".getBytes();
            signature.update(dataToBeSigned);
            byte[] signedData = signature.sign();

            // Printing the signed data in base64 format for verification
            System.out.println(java.util.Base64.getEncoder().encodeToString(signedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}