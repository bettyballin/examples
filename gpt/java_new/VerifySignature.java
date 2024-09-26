import java.io.InputStream;
import java.security.PublicKey;
import java.security.Signature;

public class VerifySignature {
    public static void main(String[] args) {
        try {
            InputStream dataInputStream = /* initialized elsewhere */;
            byte[] signatureBytes = /* initialized elsewhere */;
            PublicKey publicKey = /* initialized elsewhere */;

            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(publicKey);

            byte[] buffer = new byte[2048];
            int numRead;
            while ((numRead = dataInputStream.read(buffer)) >= 0) {
                sig.update(buffer, 0, numRead);
            }

            boolean verifies = sig.verify(signatureBytes);
            System.out.println("Signature verifies: " + verifies);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}