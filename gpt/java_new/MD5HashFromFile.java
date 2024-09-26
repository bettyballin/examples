import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashFromFile {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: MD5HashFromFile <file path>");
            return;
        }
        String path = args[0];
        try {
            String md5Hash = getMD5Checksum(path);
            System.out.println("MD5 Hash of file content: " + md5Hash);
        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
        }
    }

    public static String getMD5Checksum(String filepath) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream fis = new FileInputStream(filepath)) {
            byte[] buffer = new byte[1024];
            int numRead;
            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    md.update(buffer, 0, numRead);
                }
            } while (numRead != -1);
        }
        return bytesToHex(md.digest());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}