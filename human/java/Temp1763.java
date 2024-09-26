import java.io.FileInputStream;
import java.io.IOException;

public class Temp1763 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/dev/random")) {
            byte[] buffer = new byte[8];
            int bytesRead = fis.read(buffer);
            System.out.println("Read " + bytesRead + " bytes from /dev/random");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}