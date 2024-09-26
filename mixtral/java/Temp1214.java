import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.slf4j.LoggerFactory;

public class Temp1214 {
    public static void main(String[] args) {
        Temp1214 temp = new Temp1214();
        // Example usage:
        // PrivateKey privateKey = temp.loadPrivateKey("path/to/private/key");
    }

    private PrivateKey loadPrivateKey(String location) {
        try (BufferedReader r = new BufferedReader(new FileReader(location))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = r.readLine()) != null) {
                if (!line.contains("EC PRIVATE KEY"))
                    sb.append(line);
            }

            byte[] bytes = Base64.getDecoder().decode(sb.toString());

            return KeyFactory.getInstance("ECDSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));
        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger("Nectar").error("Failed to find Private KEY: " + location);
            System.exit(1);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            // Handle exceptions
        }

        return null;
    }
}