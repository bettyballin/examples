import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Temp462 {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
                new BoundedInputStream(getInfiniteReader(), 1024 * 10)))) {
            String firstLine = bf.readLine();
            System.out.println(firstLine); // Just to verify that it reads something.
        } catch (IOException e) {
            // Handle exception here.
            e.printStackTrace();
        }
    }

    // Mock implementation of BoundedInputStream
    static class BoundedInputStream extends InputStreamReader {
        private long maxBytes;
        private long bytesRead = 0;

        public BoundedInputStream(Reader in, long maxBytes) {
            super(in);
            this.maxBytes = maxBytes;
        }

        @Override
        public int read() throws IOException {
            if (bytesRead >= maxBytes) {
                return -1;
            }
            int result = super.read();
            if (result != -1) {
                bytesRead++;
            }
            return result;
        }

        @Override
        public int read(char[] cbuf, int offset, int length) throws IOException {
            if (bytesRead >= maxBytes) {
                return -1;
            }
            int bytesToRead = (int) Math.min(length, maxBytes - bytesRead);
            int result = super.read(cbuf, offset, bytesToRead);
            if (result != -1) {
                bytesRead += result;
            }
            return result;
        }
    }

    // Mock implementation of getInfiniteReader
    public static Reader getInfiniteReader() {
        return new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) {
                for (int i = 0; i < len; i++) {
                    cbuf[off + i] = 'a'; // Just filling with 'a' for simplicity.
                }
                return len;
            }

            @Override
            public void close() {
            }
        };
    }
}