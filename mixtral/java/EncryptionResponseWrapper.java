import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class EncryptionResponseWrapper extends HttpServletResponseWrapper {
    private ServletOutputStream servletStream;
    private PrintWriter writer;

    public EncryptionResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        servletStream = new EncryptionServletOutputStream(response.getOutputStream(), response.getCharacterEncoding());
        writer = new PrintWriter(new OutputStreamWriter(servletStream, response.getCharacterEncoding()));
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return servletStream;
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }

    private static class EncryptionServletOutputStream extends ServletOutputStream {
        private final ServletOutputStream original;
        private final ByteArrayOutputStream byteArrayOutputStream;
        private final String encoding;

        public EncryptionServletOutputStream(ServletOutputStream original, String encoding) {
            this.original = original;
            this.byteArrayOutputStream = new ByteArrayOutputStream();
            this.encoding = encoding;
        }

        @Override
        public void write(int b) throws IOException {
            byteArrayOutputStream.write(b);
        }

        @Override
        public void flush() throws IOException {
            byte[] data = byteArrayOutputStream.toByteArray();
            byte[] encryptedData = encryptData(data); // Replace with your encryption logic
            original.write(encryptedData);
            original.flush();
        }

        @Override
        public void close() throws IOException {
            flush();
            original.close();
        }

        private byte[] encryptData(byte[] data) {
            // Replace with your actual encryption logic
            return data;
        }

        @Override
        public boolean isReady() {
            return original.isReady();
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            original.setWriteListener(writeListener);
        }
    }
}