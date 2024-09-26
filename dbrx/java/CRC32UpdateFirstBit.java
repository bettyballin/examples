import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public class CRC32UpdateFirstBit {
    public static void main(String[] args) {
        String input = "YourString";
        byte[] crcBytes;
        long initialCRCValue;

        // Calculate the original CRC value
        try (var inputStream = new ByteArrayInputStream(input.getBytes())) {
            var crc32 = new CRC32();
            int readByte;
            while ((readByte = inputStream.read()) != -1) {
                crc32.update(readByte);
            }
            initialCRCValue = crc32.getValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Convert the long integer into an array of bytes
        ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES).putLong(initialCRCValue);
        byteBuffer.flip(); // Add this line to reset the buffer's position
        crcBytes = byteBuffer.array();

        // Update the first bit based on your condition
        boolean condition = true;  // Replace 'condition' with a boolean expression that determines whether to set or clear the first bit.
        if (condition) {
            crcBytes[7] &= ~(byte) 128; // Change index to 7, since bytes are stored in big-endian order
        } else {
            crcBytes[7] |= (byte) 128; // Change index to 7, since bytes are stored in big-endian order
        }

        System.out.println("Updated CRC32 value: " + ByteBuffer.wrap(crcBytes).getLong());
    }
}