import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Temp1122 {
    public static void main(String[] args) {
        Checksum h = new CRC32();
        h.update(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, 0, 4);
        System.out.println("CRC32 checksum: " + h.getValue());
    }
}