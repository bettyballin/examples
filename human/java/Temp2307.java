import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.crypto.generators.SCrypt;

public class Temp2307 {
    public static void main(String[] args) {
        // Example input
        String password = "password";
        byte[] salt = "salt".getBytes();
        
        // SCrypt parameters
        int N = 16384;
        int r = 8;
        int p = 1;
        int dkLen = 32;
        
        // Generate SCrypt hash
        byte[] sCryptHash = SCrypt.generate(password.getBytes(), salt, N, r, p, dkLen);
        
        // Convert hash to hex string
        String hexString = Hex.toHexString(sCryptHash);
        
        // Print hex string
        System.out.println(hexString);
    }
}