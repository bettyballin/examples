import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Sha256Hex {
    public static void main(String[] args) {
        try {
            String seed = "your input here"; // Replace with your seed

            // Perform SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(seed.getBytes());

            // Convert the result to a hex string
            String sha256hex = DatatypeConverter.printHexBinary(encodedhash).toLowerCase();

            System.out.println(sha256hex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}