import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RedirectServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/path1") || requestURI.startsWith("/path2")
                || requestURI.startsWith("/path3")) {
            response.sendRedirect("https://" + request.getServerName() + requestURI);
        } else {
            response.sendRedirect("http://" + request.getServerName() + requestURI);
        }
    }
}