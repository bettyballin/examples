import org.owasp.encoder.Encode;

import java.io.IOException;
import java.io.Writer;

public class EscapingWriter extends Writer {

    private final Writer originalWriter;

    public EscapingWriter(Writer originalWriter) {
        this.originalWriter = originalWriter;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] escapedCbuf = new char[len];
        System.arraycopy(cbuf, off, escapedCbuf, 0, len);
        Encode.forHtml(escapedCbuf);
        originalWriter.write(escapedCbuf, 0, len);
    }

    @Override
    public void flush() throws IOException {
        originalWriter.flush();
    }

    @Override
    public void close() throws IOException {
        originalWriter.close();
    }
}