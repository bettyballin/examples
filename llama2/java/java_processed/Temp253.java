import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;

public class Temp253 {
    public static void main(String[] args) {
        try {
            // Sample private key data for demonstration purposes
            byte[] privateKeyData = new byte[]{48, -126, 2, 117, 2, 1, 0, 2, -127, -127, 0, -48, -33, -68, 85, 49, 87, 97, 88, -98, -115, 51, 73, 77, -106, -72, -17, -39, 76, -72, -12, -115, -71, -1, -47, -50, 32, 111, -26, -97, 26, 24, 111, 90, -22, -62, -61, -25, -105, -46, -76, 59, -57, -69, -62, 30, 16, 16, -101, -8, 53, 122, 54, -27, -118, -109, -122, 34, 69, -82, -7, -113, 97, -65, -127, -98, 42, -82, 93, -111, -116, -127, -107, -4, 63, 91, -107, 20, -12, -20, -61, -25, -124, -86, 119, 95, 76, 39, -1, -30, 51, -109, -127, -48, -7, -84, 115, 68, -97, -4, -54, -24, 72, -26, -15, 99, -47, -71, 34, -96, 67, 112, -43, 71, -112, 5, 2, 3, 1, 0, 1, 2, -127, -128, 48, 119, 71, -107, -52, 124, 10, 6, -101, -111, 111, -104, -53, -106, -68, 116, 45, 33, 25, 8, -104, -18, -43, -122, -48, -30, -109, 28, 101, -105, 99, -89, 117, 83, -116, 8, -35, 5, 96, 3, 21, 68, 52, 8, -30, -95, 68, -61, 119, 123, 112, -31, -9, -39, -38, 124, 83, 49, 106, 94, 14, 16, 32, 70, 122, 93, 98, -74, -91, -69, -58, -3, -56, 92, -7, -15, -13, 122, -102, -66, -98, -81, 123, -48, 36, 42, -74, -44, -40, 45, -43, -121, -28, 44, 124, -27, -48, -34, 24, 32, 84, -12, -106, 72, -117, -38, -1, 32, 49, -5, 69, -22, 30, 110, -94, -117, 2, 65, 0, -119, -67, -98, -19, 82, -62, -34, 18, 89, 109, 38, 14, 42, -105, -114, -39, 87, 123, 44, -53, 90, 122, -21, -36, -51, -45, -9, 34, 88, -68, -37, -2, -104, 72, 6, -39, -99, -123, -103, 31, 57, 36, 44, -124, -50, -110, -110, -22, 49, -5, 34, -28, 38};

            KeyFactory kf = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyData);
            PublicKey privateKey = kf.generatePublic(keySpec);

            System.out.println(privateKey.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not found: " + e.getMessage());
        } catch (InvalidKeySpecException e) {
            System.err.println("Invalid key spec: " + e.getMessage());
        }
    }
}