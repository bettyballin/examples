import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp353 {
    public static void main(String[] args) {
        try {
            String inputString1 = "Hello";
            String inputString2 = "World";

            // Create a SHA-256 message digest object
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            // Hash the two input strings
            byte[] hash1 = sha256.digest(inputString1.getBytes());
            byte[] hash2 = sha256.digest(inputString2.getBytes());

            // Concatenate the two hashes
            byte[] result = new byte[hash1.length + hash2.length];
            System.arraycopy(hash1, 0, result, 0, hash1.length);
            System.arraycopy(hash2, 0, result, hash1.length, hash2.length);

            // Convert the resulting bytes to a string
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            String generatedString = sb.toString();

            System.out.println("Generated String: " + generatedString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}