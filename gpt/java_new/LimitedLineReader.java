import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LimitedLineReader extends BufferedReader {
    private final int maxLineLength;

    public LimitedLineReader(Reader in, int maxLineLength) {
        super(in);
        this.maxLineLength = maxLineLength;
    }

    @Override
    public String readLine() throws IOException {
        StringBuilder lineBuffer = new StringBuilder();
        int readChars = 0;
        int ch;
        boolean eol = false;

        while (!eol && (ch = super.read()) != -1) {
            switch (ch) {
                case '
':
                    eol = true;
                    break;
                case '\r':
                    eol = true;
                    long cur = super.skip(1);
                    if (cur == 0 && super.read() != '
') {
                        super.reset();
                    }
                    break;
                default:
                    lineBuffer.append((char) ch);
                    readChars++;
                    if (readChars > maxLineLength) {
                        throw new IOException("Line is too long");
                    }
                    break;
            }
        }
        if (readChars == 0 && ch == -1) {
            return null; // EOF
        }
        return lineBuffer.toString();
    }
}