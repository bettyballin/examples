import java.nio.ByteBuffer;

public class ClearBuffer {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(64);  // Example size, adjust as needed
        bb.clear();
        while (bb.remaining() >= 8) {
            bb.putLong(0);
        }
        while (bb.remaining() > 0) {
            bb.put((byte) 0);
        }
    }
}