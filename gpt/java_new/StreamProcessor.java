import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamProcessor {
    public void processStream(InputStream cipherInputStream, FileOutputStream fos) throws IOException {
        byte[] decodedByteChunk = new byte[1024];
        int bytesRead;
        while ((bytesRead = cipherInputStream.read(decodedByteChunk)) != -1) {
            fos.write(decodedByteChunk, 0, bytesRead);
        }
    }
}