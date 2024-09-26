import java.util.Base64;
import java.util.Arrays;

public class Temp1989 {
    public static void main(String[] args) {
        byte[] publicKeyBytes = new byte[256]; // Dummy byte array for demonstration
        for (int j = 0; j < publicKeyBytes.length; j++) {
            publicKeyBytes[j] = (byte) j; // Populate the array with some data
        }
        
        StringBuilder pemPublicKey = new StringBuilder();
        pemPublicKey.append("-----BEGIN PUBLIC KEY-----\n");
        
        for (int i = 0; i < publicKeyBytes.length; i += 64) {
            if (i + 64 < publicKeyBytes.length) {
                pemPublicKey.append(new String(Base64.getEncoder().encode(Arrays.copyOfRange(publicKeyBytes, i, i + 64))));
            } else {
                pemPublicKey.append(new String(Base64.getEncoder().encode(Arrays.copyOfRange(publicKeyBytes, i, publicKeyBytes.length))));
            }
            pemPublicKey.append("\n");
        }
        
        pemPublicKey.append("-----END PUBLIC KEY-----\n");
        System.out.println(pemPublicKey);
    }
}