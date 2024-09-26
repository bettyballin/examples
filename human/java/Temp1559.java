import java.security.cert.X509Certificate;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class Temp1559 extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        X509Certificate[] certificates = (X509Certificate[]) request
                .getAttribute("javax.servlet.request.X509Certificate");

        response.getWriter().println("<h1>Certificate Information</h1>");
        if (certificates != null) {
            for (X509Certificate certificate : certificates) {
                response.getWriter().println("<p>" + certificate.toString() + "</p>");
            }
        } else {
            response.getWriter().println("<p>No certificates found.</p>");
        }
    }

    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        server.setHandler(new Temp1559());

        server.start();
        server.join();
    }
}