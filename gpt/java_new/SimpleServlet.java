import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String referer = req.getHeader("Referer");
        String allowedDomain = "https://www.yourwebsite.com";

        if (referer != null && referer.startsWith(allowedDomain)) {
            resp.setContentType("text/plain");
            resp.getWriter().println(req.getParameter("name"));
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied.");
        }
    }
}