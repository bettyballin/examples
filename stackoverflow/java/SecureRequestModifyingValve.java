import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

public class SecureRequestModifyingValve extends ValveBase {
    private static final String LB_HTTPS_HEADER = "Front-End-Https";

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        String httpsHeader = request.getHeader(LB_HTTPS_HEADER);
        request.setSecure(httpsHeader != null && "on".equalsIgnoreCase(httpsHeader));
        getNext().invoke(request, response);
    }
}