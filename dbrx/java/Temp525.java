import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;

public class Temp525 {
    static {
        java.security.Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        // Example usage
        PublicKey publicKey = strToPublicKey("path/to/public/key.pem");
        if (publicKey != null) {
            System.out.println("Public key loaded successfully.");
        } else {
            System.out.println("Failed to load public key.");
        }
    }

    public static PublicKey strToPublicKey(String s) {
        try {
            InputStream inputStream = new FileInputStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            PEMReader pr = new PEMReader(br);
            Object obj = pr.readObject();

            if (obj instanceof PublicKey) {
                return (PublicKey) obj;
            }

            // Handle other cases as needed

        } catch (Exception e) {
            System.err.println("Error loading public key: " + e.getMessage());
        }

        return null;
    }
}