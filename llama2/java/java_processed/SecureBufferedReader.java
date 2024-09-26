import java.io.*;

public class SecureBufferedReader extends BufferedReader {
    private int maxBytesPerLine;
    private char[] buffer;
    private int bufferSize;
    private int pos;

    public SecureBufferedReader(InputStream inputStream, int bufferSize, int maxBytesPerLine) {
        super(new InputStreamReader(inputStream), bufferSize);
        this.bufferSize = bufferSize;
        this.maxBytesPerLine = maxBytesPerLine;
        this.buffer = new char[bufferSize];
        this.pos = 0;
    }

    @Override
    public String readLine() throws IOException {
        ensureCapacity();

        // Check if there's enough data in the buffer to satisfy the maximum limit
        int availableData = bufferSize - pos;
        if (availableData < maxBytesPerLine) {
            // Fill the buffer with more data from the underlying input stream
            fillBuffer(maxBytesPerLine - availableData);
        }

        // Scan through the buffer to find the return line character or the end of the buffer
        for (int i = pos; i < pos + maxBytesPerLine && i < bufferSize; i++) {
            if (buffer[i] == '\n') {
                String line = new String(buffer, pos, i - pos);
                pos = i + 1;
                return line;
            }
        }

        // If the maximum limit is reached without finding a return line character, throw an exception
        throw new IOException("Maximum line length exceeded");
    }

    private void ensureCapacity() throws IOException {
        // Ensure the buffer has enough capacity
        if (buffer == null) {
            buffer = new char[bufferSize];
        }
    }

    private void fillBuffer(int minBytes) throws IOException {
        // Fill the buffer with at least minBytes of data from the underlying input stream
        int bytesRead = 0;
        while (bytesRead < minBytes) {
            int result = super.read(buffer, pos + bytesRead, bufferSize - pos - bytesRead);
            if (result == -1) {
                break;
            }
            bytesRead += result;
        }
    }

    public static void main(String[] args) {
        try (InputStream inputStream = new ByteArrayInputStream("Hello\nWorld\nThis is a test".getBytes());
             SecureBufferedReader reader = new SecureBufferedReader(inputStream, 1024, 10)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}