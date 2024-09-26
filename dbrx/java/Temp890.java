import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp890 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String originalUrl = request.getParameter("originalUrl");
        String localUrl = "/local" + originalUrl;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(localUrl);
        if (requestDispatcher != null) {
            requestDispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public static void main(String[] args) throws Exception {
        javax.servlet.http.HttpServlet servlet = new Temp890();
        servlet.init(new org.apache.catalina.core.StandardWrapper());
        javax.servlet.http.HttpServletRequest request = new org.apache.catalina.connector.RequestFacade(null);
        javax.servlet.http.HttpServletResponse response = new org.apache.catalina.connector.ResponseFacade(null);
        servlet.doGet(request, response);
    }
}