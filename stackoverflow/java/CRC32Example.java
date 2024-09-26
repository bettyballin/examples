import java.util.zip.CRC32;

public class CRC32Example {
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        // Update the crc32 object with bytes from a data source here
        // e.g. crc32.update(someByteArray);

        long crc = crc32.getValue();
        crc &= 0x7FFFFFFFL; //sets the highest bit to 0
        boolean yourCondition = false; // Replace with your actual condition
        if (yourCondition) {
            crc |= 0x80000000L; //sets the highest bit to 1
        }

        System.out.println("CRC Value: " + crc);
    }
}