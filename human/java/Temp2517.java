import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Temp2517 {
    public static void main(String[] args) {
        long nonce = 123456789L; // Example value for nonce
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(nonce);

        // Print buffer content for demonstration
        buffer.flip(); // Prepare buffer for reading
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
    }
}