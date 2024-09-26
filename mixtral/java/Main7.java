import java.util.zip.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "Hello World!";

        CRC32 crc32 = new CRC32();

        byte[] bytes = input.getBytes("UTF-8");

        // Calculate the initial checksum
        for (byte b : bytes)
            crc32.update(b);

        long originalCheckSum = crc32.getValue();

        System.out.println("Original CRC: " + Long.toHexString(originalCheckSum));

        // Update the first bit based on some condition
        boolean someCondition = true; // Replace with actual condition

        if (someCondition) {
            // Set it to 1
            long updatedCRC = originalCheckSum | 0x8000_0000L;

            System.out.println("Updated CRC with First Bit set: " + Long.toHexString(updatedCRC));
        } else {
            // Set it to 0
            long updatedCRC = originalCheckSum & ~0x8000_0000L;

            System.out.println("Updated CRC with First Bit cleared: " + Long.toHexString(updatedCRC));
        }
    }
}