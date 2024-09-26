import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;

public class HashGenerator {
    public static String generateHash(String input1, String input2) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest1 = md.digest(input1.getBytes());
        byte[] messageDigest2 = md.digest(input2.getBytes());
        byte[] messageDigest = new byte[messageDigest1.length];

        // Combine the digests
        for (int i = 0; i < messageDigest1.length && i < messageDigest2.length; i++) {
            messageDigest[i] = (byte) ((messageDigest1[i] & 0xFF) ^ (messageDigest2[i] & 0xFF));
        }

        // Truncate the result to desired length
        byte[] truncatedResult = Arrays.copyOfRange(messageDigest, 0, 28);

        return DatatypeConverter.printHexBinary(truncatedResult);
    }

    public static void main(String[] args) throws Exception {
        // Example usage
        String input1 = "Hello";
        String input2 = "World";
        String result = generateHash(input1, input2);
        System.out.println("Generated Hash: " + result);
    }
}