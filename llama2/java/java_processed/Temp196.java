import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class Temp196 {
    public static void main(String[] args) {
        // Import the Bouncy Castle provider
        Security.addProvider(new BouncyCastleProvider());

        // Example usage of HexEncoder
        String data = "Hello, Bouncy Castle!";
        byte[] encoded = Hex.encode(data.getBytes());

        String encodedString = new String(encoded);
        System.out.println("Encoded string: " + encodedString);
    }
}