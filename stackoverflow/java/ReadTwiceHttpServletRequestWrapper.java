import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTwiceHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public ReadTwiceHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            IOUtils.copy(request.getInputStream(), outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return new ServletInputStream() {
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            public boolean isReady() {
                return true;
            }

            public void setReadListener(ReadListener readListener) {
                throw new RuntimeException("Not implemented");
            }
        };
    }

    public void setBody(String body) {
        outputStream.reset();
        try {
            outputStream.write(body.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBody() {
        return new String(outputStream.toByteArray());
    }
}