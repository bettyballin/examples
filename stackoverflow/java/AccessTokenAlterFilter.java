import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessTokenAlterFilter implements Filter {

    Logger OUT = LoggerFactory.getLogger(AccessTokenAlterFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        OUT.info("[[[[[[[[[[[[STARTED]]]]]]]]]]]]]]");

        CharResponseWrapper wrappedResponse = new CharResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrappedResponse);
        byte[] bytes = wrappedResponse.getByteArray();
        String out = new String(bytes);
        OUT.info("Response String: {}", out);

        response.getOutputStream().write(bytes);

        OUT.info("[[[[[[[[[[[[ENDED]]]]]]]]]]]]]]");
    }

    private class CharResponseWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream baos = new ByteArrayOutputStream();
        private PrintWriter pw = new PrintWriter(baos);
        private boolean usingWriter;

        public CharResponseWrapper(HttpServletResponse response) {
            super(response);
            usingWriter = false;
        }

        public byte[] getByteArray() {
            pw.flush();
            return baos.toByteArray();
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (usingWriter) {
                throw new IllegalStateException("getWriter() has already been called for this response");
            }
            usingWriter = true;
            return new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    baos.write(b);
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setWriteListener(WriteListener listener) {
                    // no-op for this implementation
                }
            };
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (usingWriter) {
                throw new IllegalStateException("getOutputStream() has already been called for this response");
            }
            usingWriter = true;
            return pw;
        }
    }
}