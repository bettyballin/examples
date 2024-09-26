import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import org.apache.commons.codec.binary.Hex;

public class ProductKeyGenerator {
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static void main(String[] args) throws Exception {
        // Generate a secret key
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);

        SecretKey sk = kg.generateKey();

        String name = "ProductName";
        int validityDays = 365;

        // Generate a random MAC address
        byte[] macBytes = new byte[6];

        SecureRandom sr = new SecureRandom();

        for (int i = 0; i < macBytes.length; i++) {
            int b = 1 + Math.abs(sr.nextInt()) % 254;
            macBytes[i] = (byte) (b & 0xFF);
        }

        String hexMac = Hex.encodeHexString(macBytes).toUpperCase();

        // Additional information
        String additionalInfo = "Additional Info...";

        System.out.println("Product Key Data:");
        System.out.println("Name: " + name);
        System.out.println("Validity Days: " + validityDays);
        System.out.println("MAC Address: " + hexMac);
        System.out.println("Additional Info: " + additionalInfo);
    }
}