import org.apache.commons.codec.digest.DigestUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChecksumExample {
    public static void main(String[] args) {
        try (FileInputStream originalFile = new FileInputStream("PiracyCheck.class");
             FileInputStream patchedFile = new FileInputStream("PiracyCheck.class")) {

            // Calculate checksum of the original PiracyCheck.class file.
            String originalChecksum = DigestUtils.md5Hex(originalFile);

            System.out.println("Original MD5: " + originalChecksum);

            // Patch your class here.

            // Recalculate and compare with previous value
            String patchedChecksum = DigestUtils.md5Hex(patchedFile);

            if (originalChecksum.equals(patchedChecksum)) {
                System.out.println("No changes detected.");
            } else {
                throw new Exception("Class was modified!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}