import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class Temp691 {
    public static void main(String[] args) {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        try {
            // Dummy content for demonstration purposes
            byte[] content = "Hello, World!".getBytes();

            // Create a CMSSignedData object
            CMSSignedData signedData = new CMSSignedData(content);

            // Print out some information about the signed data
            System.out.println("Signed Data: " + signedData.getSignedContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}