import java.io.IOException;
import java.io.InputStream;

public class SafeHttpHeaderReader {
    public static final int MAX_READ = 8 * 1024;
    private InputStream stream;
    private int bytesRead;

    public SafeHttpHeaderReader(InputStream stream) {
        this.stream = stream;
        bytesRead = 0;
    }

    public boolean hasReachedMax() {
        return bytesRead >= MAX_READ;
    }

    public String readLine() throws IOException {
        StringBuilder s = new StringBuilder();

        while (bytesRead < MAX_READ) {
            int n = read();

            if (n == -1) {
                break;
            }

            if (n == '\r') {
                int nextChar = read();
                if (nextChar == '
') {
                    break;
                } else {
                    throw new IOException("Invalid HTTP header format");
                }
            }
            s.append((char) n);
        }

        return s.toString();
    }

    private int read() throws IOException {
        int b = stream.read();
        if (b != -1) {
            bytesRead++;
        }
        return b;
    }
}