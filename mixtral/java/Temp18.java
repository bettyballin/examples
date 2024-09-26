import java.io.*;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp18 {
    public static void main(String[] args) {
        Temp18 temp = new Temp18();
        File file = new File("path_to_your_file"); // Specify the path to your file
        System.out.println(temp.createSha1(file));
    }

    public String createSha1(File file) {
        try (InputStream is = new FileInputStream(file)) {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            DigestInputStream dis = new DigestInputStream(is, md);

            // Read the entire stream to ensure that all bytes are processed
            while (dis.read() != -1) ;

            byte[] digest = md.digest();

            BigInteger bigInt = new BigInteger(1, digest);

            return String.format("%0" + (digest.length << 1) + "x", bigInt);
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while calculating SHA-1 for file: " + file, e);
        }
    }
}