import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charWriter;
    private PrintWriter writer;
    
    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
        charWriter = new CharArrayWriter();
        writer = new PrintWriter(charWriter);
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }
    
    public String getCapturedResponse() {
        return charWriter.toString();
    }

    public void commitResponse() throws IOException {
        getResponse().getOutputStream().write(charWriter.toString().getBytes());
        getResponse().getOutputStream().flush();
    }
}