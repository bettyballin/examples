import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoIFrameAllowedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
    }

    public static void main(String[] args) {
        // You would typically configure and start a web server like Tomcat or Jetty here
        // For the sake of example, this main method is left empty.
    }
}