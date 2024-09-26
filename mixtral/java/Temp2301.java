import java.nio.file.*;
import java.io.*;
import java.security.*;
import java.util.Scanner;

public class MD5Checksum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the path to the file: ");
        Path path = FileSystems.getDefault().getPath(sc.nextLine());

        try (InputStream is = Files.newInputStream(path)) {
            System.out.println("MD5: " + MD5(is));

        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String MD5(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[1024];
        int read;

        while ((read = inputStream.read(buffer)) > 0) {
            md.update(buffer, 0, read);
        }

        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; ++i) {
            int v = 0xFF & hash[i];

            if (v < 16) {
                hexString.append('0');
            }

            hexString.append(Integer.toHexString(v));
        }

        return hexString.toString();
    }
}