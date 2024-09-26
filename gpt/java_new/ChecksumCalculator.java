import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class ChecksumCalculator {
    public static String getFileChecksum(MessageDigest digest, String filePath) throws Exception {
        try (InputStream fis = new FileInputStream(filePath)) {
            byte[] byteArray = new byte[1024];
            int bytesCount;

            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
        }

        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}