import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class Temp1085 {
    public static void main(String[] args) {
        try {
            String seedString = "your_hex_string_here";
            byte[] decodedHex = HexFormat.of().parseHex(seedString);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(decodedHex);

            // Print the resulting hash in hexadecimal format
            System.out.println(HexFormat.of().formatHex(encodedhash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}