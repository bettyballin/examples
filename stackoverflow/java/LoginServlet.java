import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            req.login(username, password);
            PrintWriter out = resp.getWriter();
            out.println("<h2>Welcome</h2>");
        } catch (ServletException e) {
            PrintWriter out = resp.getWriter();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}