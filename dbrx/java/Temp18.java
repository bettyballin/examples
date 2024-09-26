import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp18 {
    public static void main(String[] args) {
        Temp18 temp = new Temp18();
        File file = new File("path_to_your_file"); // Replace with your file path
        String sha1 = temp.createSha1(file);
        System.out.println("SHA-1: " + sha1);
    }

    public String createSha1(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] buffer = new byte[8192];
            int numRead;
            while ((numRead = inputStream.read(buffer)) != -1) {
                md.update(buffer, 0, numRead);
            }
            return String.format("%040x", new java.math.BigInteger(1, md.digest()));
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}