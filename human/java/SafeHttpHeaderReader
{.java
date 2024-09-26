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

    public String readLine() throws IOException, Http400Exception {
        String s = "";

        while (bytesRead < MAX_READ) {
            String n = read();

            if (n.equals(""))
                break;

            if (n.equals("\r")) {
                if (read().equals("\n"))
                    break;

                throw new Http400Exception();
            }
            s += n;
        }

        return s;
    }

    private String read() throws IOException {
        byte b = readByte();

        if (b == -1)
            return "";

        return new String(new byte[] { b }, "ASCII");
    }

    private byte readByte() throws IOException {
        int byteValue = stream.read();
        if (byteValue == -1) {
            return -1;
        }
        bytesRead++;
        return (byte) byteValue;
    }

    public static void main(String[] args) {
        // Example usage
        String input = "GET / HTTP/1.1\r\nHost: example.com\r\n\r\n";
        InputStream stream = new java.io.ByteArrayInputStream(input.getBytes());

        SafeHttpHeaderReader reader = new SafeHttpHeaderReader(stream);
        try {
            while (!reader.hasReachedMax()) {
                String line = reader.readLine();
                if (line.isEmpty()) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException | Http400Exception e) {
            e.printStackTrace();
        }
    }
}

class Http400Exception extends Exception {
    public Http400Exception() {
        super("HTTP 400 Bad Request");
    }
}