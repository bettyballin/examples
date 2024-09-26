import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.cert.X509Certificate;

@WebServlet("/Temp75")
public class Temp75 extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object certChain = request.getAttribute("javax.servlet.request.X509Certificate");
        if (certChain != null) {
            X509Certificate certs[] = (X509Certificate[]) certChain;
            X509Certificate cert = certs[0];
            String n = cert.getSubjectDN().getName();
            response.getWriter().println("Certificate Subject DN: " + n);
        } else {
            response.getWriter().println("No certificate chain found.");
        }
    }

    public static void main(String[] args) {
        System.out.println("This servlet should be deployed on a servlet container.");
    }
}