import java.util.zip.CRC32;

public class Temp1648 {
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        crc32.update("yourData".getBytes());
        long crc = crc32.getValue();

        crc &= 0x7FFFFFFF; //sets the highest bit to 0
        
        boolean yourCondition = true; // This is a placeholder. Set your actual condition here.
        
        if (yourCondition) {
            crc |= 0x80000000; //sets the highest bit to 1
        }

        System.out.println("CRC Value: " + crc);
    }
}