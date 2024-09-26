import java.util.zip.CRC32;

public class CRC32UpdateFirstBit {
    public static void main(String[] args) {
        String input = "Your input string";
        CRC32 crc32 = new CRC32();
        crc32.update(input.getBytes());

        // Get the current CRC32 checksum value
        long checksum = crc32.getValue();
        System.out.println("Original CRC32: " + Long.toHexString(checksum));

        // Set the first bit to 1 (set the bit)
        long mask = 0x80000000L; // Mask with only the first bit set to 1
        long updatedChecksum = checksum | mask;

        System.out.println("Updated CRC32 with first bit set to 1: " + Long.toHexString(updatedChecksum));
    }
}